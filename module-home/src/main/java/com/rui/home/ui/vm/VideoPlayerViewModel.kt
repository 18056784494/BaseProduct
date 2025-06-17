package com.rui.home.ui.vm

import androidx.lifecycle.MutableLiveData
import com.rui.mvvmlazy.base.BaseViewModel
import com.rui.mvvmlazy.bus.event.SingleLiveEvent
import com.rui.mvvmlazy.utils.common.KLog

class VideoPlayerViewModel : BaseViewModel() {
    private val TAG = "VideoPlayerViewModel"

    // 视频播放完成事件
    val videoCompleted = SingleLiveEvent<Unit>()

    // 视频播放错误事件
    val videoError = SingleLiveEvent<String>()

    // 视频播放进度
    val videoProgress = MutableLiveData<Long>()

    // 视频总时长
    val videoDuration = MutableLiveData<Long>()

    // 视频播放状态
    val isPlaying = MutableLiveData<Boolean>()

    // 视频播放完成
    fun onVideoCompleted() {
        KLog.d(TAG, "视频播放完成")
        videoCompleted.call()
    }

    // 视频播放错误
    fun onVideoError(error: String) {
        KLog.e(TAG, "视频播放错误: $error")
        videoError.value = error
    }

    // 更新播放进度
    fun updateProgress(position: Long) {
        videoProgress.value = position
    }

    // 更新视频时长
    fun updateDuration(duration: Long) {
        videoDuration.value = duration
    }

    // 更新播放状态
    fun updatePlayState(playing: Boolean) {
        isPlaying.value = playing
    }
} 