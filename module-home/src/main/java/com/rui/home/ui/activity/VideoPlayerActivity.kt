package com.rui.home.ui.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.rui.base.router.RouterActivityPath
import com.rui.home.BR
import com.rui.home.R
import com.rui.home.databinding.ActivityVideoPlayerBinding
import com.rui.home.ui.vm.VideoPlayerViewModel
import com.rui.home.utils.VideoPlayerManager
import com.rui.mvvmlazy.base.activity.BaseVmDbActivity
import com.rui.mvvmlazy.utils.common.KLog

/**
 * 视频播放页面
 */
@Route(path = RouterActivityPath.Home.VIDEO_PLAYER)
class VideoPlayerActivity : BaseVmDbActivity<VideoPlayerViewModel, ActivityVideoPlayerBinding>() {
    private val TAG = "VideoPlayerActivity"
    private val playerManager = VideoPlayerManager.getInstance()
    private var isFirstVideo = true
    
    override fun initContentView(): Int = R.layout.activity_video_player

    override fun initVariableId(): Int = BR.viewModel

    override fun initData() {
        super.initData()
        // 初始化播放器
        initPlayer()
        // 开始播放视频
        startPlay()
        // 创建观察者
        createObserver()
    }

    private fun createObserver() {
        // 观察视频播放完成事件
        viewModel.videoCompleted.observe(this, Observer {
            KLog.d(TAG, "视频播放完成，准备播放下一个视频")
            if (isFirstVideo) {
                // 播放第二个视频
                playSecondVideo()
                isFirstVideo = false
            } else {
                // 两个视频都播放完成，跳转到登录页面
                ARouter.getInstance()
                    .build(RouterActivityPath.Sign.LOGIN)
                    .navigation()
                finish()
            }
        })

        // 观察视频播放错误事件
        viewModel.videoError.observe(this, Observer { error ->
            KLog.e(TAG, "视频播放错误: $error")
            // 发生错误时也跳转到登录页面
            ARouter.getInstance()
                .build(RouterActivityPath.Sign.LOGIN)
                .navigation()
            finish()
        })
    }

    private fun initPlayer() {
        // 创建播放器配置
        val config = VideoPlayerManager.PlayerConfig(
            autoPlay = true,
            loop = false,
            showControls = false,
            keepScreenOn = true,
            volume = 1.0f
        )

        // 初始化播放器
        playerManager.init(this, binding.playerView, config)
        
        // 设置播放器状态监听
        playerManager.setOnPlayerStateChangedListener { state ->
            when (state) {
                VideoPlayerManager.PlayerState.BUFFERING -> {
                    KLog.d(TAG, "视频缓冲中")
                }
                VideoPlayerManager.PlayerState.READY -> {
                    KLog.d(TAG, "视频准备就绪")
                }
                VideoPlayerManager.PlayerState.ENDED -> {
                    viewModel.onVideoCompleted()
                }
                VideoPlayerManager.PlayerState.ERROR -> {
                    viewModel.onVideoError("播放器错误")
                }
                else -> {}
            }
        }

        // 设置播放状态监听
        playerManager.setOnPlaybackStateChangedListener { state ->
            when (state) {
                VideoPlayerManager.PlaybackState.PLAYING -> {
                    KLog.d(TAG, "视频开始播放")
                }
                VideoPlayerManager.PlaybackState.PAUSED -> {
                    KLog.d(TAG, "视频暂停播放")
                }
                VideoPlayerManager.PlaybackState.STOPPED -> {
                    KLog.d(TAG, "视频停止播放")
                }
            }
        }

        // 设置播放错误监听
        playerManager.setOnErrorListener { error ->
            viewModel.onVideoError(error)
        }
    }

    private fun startPlay() {
        try {
            // 播放第一个视频
            val videoPath = "file:///android_asset/videos/opening.mp4"
            KLog.d(TAG, "开始播放第一个视频: $videoPath")
            playerManager.play(videoPath)
            // 隐藏文字显示
            binding.textOverlayContainer.visibility = android.view.View.GONE
        } catch (e: Exception) {
            KLog.e(TAG, "播放视频失败: ${e.message}")
            viewModel.onVideoError("播放视频失败: ${e.message}")
        }
    }

    private fun playSecondVideo() {
        try {
            // 播放第二个视频
            val videoPath = "file:///android_asset/videos/belo.mp4"
            KLog.d(TAG, "开始播放第二个视频: $videoPath")
            playerManager.play(videoPath)
            // 显示文字
            binding.textOverlayContainer.visibility = android.view.View.VISIBLE
            binding.titleText.text = "Belo"
            binding.overlayText.text = "嘿,冻坏了吧?\n能快进来,炉火还暖和着呢"
        } catch (e: Exception) {
            KLog.e(TAG, "播放第二个视频失败: ${e.message}")
            viewModel.onVideoError("播放第二个视频失败: ${e.message}")
        }
    }

    override fun onPause() {
        super.onPause()
        playerManager.pause()
    }

    override fun onResume() {
        super.onResume()
        playerManager.resume()
    }

    override fun onDestroy() {
        super.onDestroy()
        playerManager.release()
    }
} 