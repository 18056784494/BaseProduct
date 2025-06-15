package com.rui.base.manager

import android.content.Context
import com.netease.nis.quicklogin.QuickLogin
import com.netease.nis.quicklogin.listener.QuickLoginPreMobileListener
import com.rui.mvvmlazy.base.appContext
import com.rui.mvvmlazy.utils.common.KLog

/**
 * 网易易盾一键登录管理类
 */
object QuickLoginManager {
    private const val TAG = "QuickLoginManager"
    
    // 配置相关
    private const val YIDUN_APP_KEY = "网易云id密钥" // TODO: 替换为实际的密钥
    private const val PREFETCH_TIMEOUT = 5000L // 预取超时时间
    
    // 状态管理
    private var isInitialized = false
    private var isPrefetching = false
    
    private val quickLogin by lazy {
        QuickLogin.getInstance()
    }
    
    /**
     * 初始化一键登录
     * @return 是否初始化成功
     */
    fun init(): Boolean {
        return try {
            if (!isInitialized) {
                quickLogin.init(appContext, YIDUN_APP_KEY)
                isInitialized = true
                KLog.d(TAG, "QuickLogin initialized successfully")
            }
            true
        } catch (e: Exception) {
            KLog.e(TAG, "Failed to initialize QuickLogin: ${e.message}")
            false
        }
    }
    
    /**
     * 预取手机号
     * @param listener 回调监听器
     * @param timeout 超时时间，默认5秒
     */
    fun prefetchMobileNumber(
        listener: QuickLoginPreMobileListener,
        timeout: Long = PREFETCH_TIMEOUT
    ) {
        if (!isInitialized) {
            KLog.e(TAG, "QuickLogin not initialized")
            listener.onGetMobileNumberError(null, "QuickLogin not initialized")
            return
        }
        
        if (isPrefetching) {
            KLog.w(TAG, "Already prefetching mobile number")
            return
        }
        
        isPrefetching = true
        try {
            quickLogin.prefetchMobileNumber(object : QuickLoginPreMobileListener {
                override fun onGetMobileNumberSuccess(YDToken: String?, mobileNumber: String?) {
                    isPrefetching = false
                    KLog.d(TAG, "Prefetch mobile number success: $mobileNumber")
                    listener.onGetMobileNumberSuccess(YDToken, mobileNumber)
                }

                override fun onGetMobileNumberError(YDToken: String?, msg: String?) {
                    isPrefetching = false
                    KLog.e(TAG, "Prefetch mobile number failed: $msg")
                    listener.onGetMobileNumberError(YDToken, msg)
                }
            })
        } catch (e: Exception) {
            isPrefetching = false
            KLog.e(TAG, "Exception while prefetching mobile number: ${e.message}")
            listener.onGetMobileNumberError(null, e.message ?: "Unknown error")
        }
    }
    
    /**
     * 获取手机号
     * @param listener 回调监听器
     */
    fun getMobileNumber(listener: QuickLoginPreMobileListener) {
        if (!isInitialized) {
            KLog.e(TAG, "QuickLogin not initialized")
            listener.onGetMobileNumberError(null, "QuickLogin not initialized")
            return
        }
        
        try {
            quickLogin.prefetchMobileNumber(object : QuickLoginPreMobileListener {
                override fun onGetMobileNumberSuccess(YDToken: String?, mobileNumber: String?) {
                    KLog.d(TAG, "Get mobile number success: $mobileNumber")
                    listener.onGetMobileNumberSuccess(YDToken, mobileNumber)
                }

                override fun onGetMobileNumberError(YDToken: String?, msg: String?) {
                    KLog.e(TAG, "Get mobile number failed: $msg")
                    listener.onGetMobileNumberError(YDToken, msg)
                }
            })
        } catch (e: Exception) {
            KLog.e(TAG, "Exception while getting mobile number: ${e.message}")
            listener.onGetMobileNumberError(null, e.message ?: "Unknown error")
        }
    }
    
    /**
     * 检查是否已初始化
     */
    fun isInitialized(): Boolean = isInitialized
    
    /**
     * 检查是否正在预取手机号
     */
    fun isPrefetching(): Boolean = isPrefetching
    
    /**
     * 重置状态
     */
    fun reset() {
        isInitialized = false
        isPrefetching = false
    }
} 