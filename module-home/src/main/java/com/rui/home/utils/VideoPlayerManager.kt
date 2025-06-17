package com.rui.home.utils

import android.content.Context
import android.view.View
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.video.VideoSize
import com.rui.mvvmlazy.utils.common.KLog

/**
 * 视频播放器管理类
 * 提供统一的视频播放接口和状态管理
 */
class VideoPlayerManager private constructor() {
    private var player: ExoPlayer? = null
    private var playerView: PlayerView? = null
    private var isInitialized = false

    // 播放器配置
    private var autoPlay = true
    private var loop = false
    private var showControls = false
    private var keepScreenOn = true
    private var volume = 1.0f

    // 状态回调
    private var onPlayerStateChangedListener: ((PlayerState) -> Unit)? = null
    private var onVideoSizeChangedListener: ((VideoSize) -> Unit)? = null
    private var onPlaybackStateChangedListener: ((PlaybackState) -> Unit)? = null
    private var onCompletionListener: (() -> Unit)? = null
    private var onErrorListener: ((String) -> Unit)? = null
    private var onProgressListener: ((Long, Long) -> Unit)? = null

    companion object {
        @Volatile
        private var instance: VideoPlayerManager? = null

        fun getInstance(): VideoPlayerManager {
            return instance ?: synchronized(this) {
                instance ?: VideoPlayerManager().also { instance = it }
            }
        }
    }

    /**
     * 播放器状态枚举
     */
    enum class PlayerState {
        IDLE,           // 空闲状态
        BUFFERING,      // 缓冲中
        READY,          // 准备就绪
        ENDED,          // 播放结束
        ERROR           // 错误状态
    }

    /**
     * 播放状态枚举
     */
    enum class PlaybackState {
        PLAYING,        // 播放中
        PAUSED,         // 暂停
        STOPPED         // 停止
    }

    /**
     * 初始化播放器
     * @param context 上下文
     * @param playerView 播放器视图
     * @param config 播放器配置
     */
    fun init(
        context: Context,
        playerView: PlayerView,
        config: PlayerConfig = PlayerConfig()
    ) {
        if (isInitialized) {
            KLog.w("VideoPlayerManager", "播放器已经初始化")
            return
        }

        this.playerView = playerView
        this.autoPlay = config.autoPlay
        this.loop = config.loop
        this.showControls = config.showControls
        this.keepScreenOn = config.keepScreenOn
        this.volume = config.volume

        player = ExoPlayer.Builder(context).build().apply {
            // 设置播放器监听
            addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(state: Int) {
                    val playerState = when (state) {
                        Player.STATE_IDLE -> PlayerState.IDLE
                        Player.STATE_BUFFERING -> PlayerState.BUFFERING
                        Player.STATE_READY -> PlayerState.READY
                        Player.STATE_ENDED -> PlayerState.ENDED
                        else -> PlayerState.ERROR
                    }
                    onPlayerStateChangedListener?.invoke(playerState)
                }

                override fun onIsPlayingChanged(isPlaying: Boolean) {
                    val playbackState = when {
                        isPlaying -> PlaybackState.PLAYING
                        else -> PlaybackState.PAUSED
                    }
                    onPlaybackStateChangedListener?.invoke(playbackState)
                }

                override fun onVideoSizeChanged(videoSize: VideoSize) {
                    onVideoSizeChangedListener?.invoke(videoSize)
                }

                override fun onPlayerError(error: com.google.android.exoplayer2.PlaybackException) {
                    onErrorListener?.invoke(error.message ?: "未知错误")
                }
            })

            // 应用配置
            playWhenReady = autoPlay
            repeatMode = if (loop) Player.REPEAT_MODE_ALL else Player.REPEAT_MODE_OFF
            volume = this@VideoPlayerManager.volume
        }

        // 配置播放器视图
        playerView.apply {
            player = this@VideoPlayerManager.player
            useController = showControls
            keepScreenOn = this@VideoPlayerManager.keepScreenOn
        }

        isInitialized = true
    }

    /**
     * 播放视频
     * @param url 视频地址
     */
    fun play(url: String) {
        if (!isInitialized) {
            KLog.e("VideoPlayerManager", "播放器未初始化")
            return
        }

        val mediaItem = MediaItem.fromUri(url)
        player?.apply {
            setMediaItem(mediaItem)
            prepare()
            play()
        }
    }

    /**
     * 暂停播放
     */
    fun pause() {
        player?.pause()
    }

    /**
     * 继续播放
     */
    fun resume() {
        player?.play()
    }

    /**
     * 停止播放
     */
    fun stop() {
        player?.stop()
    }

    /**
     * 跳转到指定位置
     * @param positionMs 目标位置（毫秒）
     */
    fun seekTo(positionMs: Long) {
        player?.seekTo(positionMs)
    }

    /**
     * 设置音量
     * @param volume 音量大小（0.0f - 1.0f）
     */
    fun setVolume(volume: Float) {
        this.volume = volume.coerceIn(0f, 1f)
        player?.volume = this.volume
    }

    /**
     * 设置是否循环播放
     * @param loop 是否循环
     */
    fun setLoop(loop: Boolean) {
        this.loop = loop
        player?.repeatMode = if (loop) Player.REPEAT_MODE_ALL else Player.REPEAT_MODE_OFF
    }

    /**
     * 设置是否显示控制器
     * @param show 是否显示
     */
    fun setShowControls(show: Boolean) {
        this.showControls = show
        playerView?.useController = show
    }

    /**
     * 设置是否保持屏幕常亮
     * @param keepScreenOn 是否保持常亮
     */
    fun setKeepScreenOn(keepScreenOn: Boolean) {
        this.keepScreenOn = keepScreenOn
        playerView?.keepScreenOn = keepScreenOn
    }

    /**
     * 设置播放器状态变化监听
     */
    fun setOnPlayerStateChangedListener(listener: (PlayerState) -> Unit) {
        onPlayerStateChangedListener = listener
    }

    /**
     * 设置播放状态变化监听
     */
    fun setOnPlaybackStateChangedListener(listener: (PlaybackState) -> Unit) {
        onPlaybackStateChangedListener = listener
    }

    /**
     * 设置视频尺寸变化监听
     */
    fun setOnVideoSizeChangedListener(listener: (VideoSize) -> Unit) {
        onVideoSizeChangedListener = listener
    }

    /**
     * 设置播放完成监听
     */
    fun setOnCompletionListener(listener: () -> Unit) {
        onCompletionListener = listener
    }

    /**
     * 设置播放错误监听
     */
    fun setOnErrorListener(listener: (String) -> Unit) {
        onErrorListener = listener
    }

    /**
     * 设置播放进度监听
     */
    fun setOnProgressListener(listener: (Long, Long) -> Unit) {
        onProgressListener = listener
    }

    /**
     * 获取当前播放位置
     */
    fun getCurrentPosition(): Long {
        return player?.currentPosition ?: 0L
    }

    /**
     * 获取视频总时长
     */
    fun getDuration(): Long {
        return player?.duration ?: 0L
    }

    /**
     * 是否正在播放
     */
    fun isPlaying(): Boolean {
        return player?.isPlaying ?: false
    }

    /**
     * 释放播放器资源
     */
    fun release() {
        player?.release()
        player = null
        playerView = null
        isInitialized = false
    }

    /**
     * 播放器配置数据类
     */
    data class PlayerConfig(
        val autoPlay: Boolean = true,
        val loop: Boolean = false,
        val showControls: Boolean = false,
        val keepScreenOn: Boolean = true,
        val volume: Float = 1.0f
    )
} 