package com.rui.home.ui.activity

import android.Manifest
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ImmersionBar
import com.netease.nis.quicklogin.listener.QuickLoginPreMobileListener
import com.permissionx.guolindev.PermissionX
import com.rui.base.manager.QuickLoginManager
import com.rui.base.router.RouterActivityPath
import com.rui.home.BR
import com.rui.home.R
import com.rui.home.databinding.HomeActivitySplashBinding
import com.rui.home.ui.viewmodel.SplashViewModel
import com.rui.mvvmlazy.base.activity.BaseVmDbActivity
import com.rui.mvvmlazy.utils.common.KLog

class SplashActivity : BaseVmDbActivity<SplashViewModel, HomeActivitySplashBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestCameraPermissions()
    }
    override fun initContentView(): Int {
        return R.layout.home_activity_splash
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initData() {
        super.initData()
    }

    override fun createStatusBarConfig(): ImmersionBar {
        return super.createStatusBarConfig() // 隐藏状态栏和导航栏
            .hideBar(BarHide.FLAG_HIDE_BAR)
    }

    private fun requestCameraPermissions() {
        PermissionX.init(this)
            .permissions(
                Manifest.permission.READ_PHONE_STATE,
            )
            .onExplainRequestReason { scope, deniedList ->
                scope.showRequestReasonDialog(
                    deniedList,
                    "Core fundamental are based on these permissions",
                    "OK",
                    "Cancel"
                )
            }
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
//                    initQuickLogin()
                    ARouter.getInstance().build(RouterActivityPath.Sign.LOGIN).navigation()
                } else {
                    showDialog("These permissions are denied: $deniedList")
                }
            }

    }
    private fun initQuickLogin() {
        if (QuickLoginManager.init()) {
            QuickLoginManager.prefetchMobileNumber(object : QuickLoginPreMobileListener {
                override fun onGetMobileNumberSuccess(YDToken: String?, mobileNumber: String?) {
                    // 预取成功，可以保存 YDToken 和 mobileNumber 供后续使用
                    KLog.d("SplashActivity", "Prefetch mobile number success: $mobileNumber")
                }

                override fun onGetMobileNumberError(YDToken: String?, msg: String?) {
                    // 预取失败，可以记录错误信息
                    KLog.e("SplashActivity", "Prefetch mobile number failed: $msg")
                }
            })
        } else {
            KLog.e("SplashActivity", "Failed to initialize QuickLogin")
        }
    }
}