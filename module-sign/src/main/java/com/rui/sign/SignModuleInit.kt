package com.rui.sign

import android.content.Context
import androidx.startup.Initializer
import com.rui.mvvmlazy.utils.common.KLog

/**
 * 组件初始化类
 * Created by zjr on 2018/6/21 0021.
 */
class SignModuleInit : Initializer<Unit> {

    override fun create(context: Context) {
        KLog.d("登录组件初始化")
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}