package com.rui.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.rui.base.manager.QuickLoginManager
import com.tencent.mmkv.BuildConfig
import com.tencent.mmkv.MMKV

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 初始化MMKV
        MMKV.initialize(this)
        
        // 初始化ARouter
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)

        // 初始化一键登录
        QuickLoginManager.init()
    }
}