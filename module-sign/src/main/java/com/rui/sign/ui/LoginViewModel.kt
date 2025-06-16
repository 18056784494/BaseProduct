package com.rui.sign.ui

import androidx.lifecycle.MutableLiveData
import com.alibaba.android.arouter.launcher.ARouter
import com.google.gson.Gson
import com.rui.base.router.RouterActivityPath
import com.rui.mvvmlazy.base.BaseViewModel
import com.rui.sign.data.repository
import com.rui.mvvmlazy.ext.request
import com.rui.mvvmlazy.state.ResultState
import com.rui.mvvmlazy.utils.common.KLog

class LoginViewModel : BaseViewModel() {
    val phone = MutableLiveData<String>()
    private val smsCode = MutableLiveData<String>()
    val isAgreementChecked = MutableLiveData<Boolean>(false)
    val toastMsg = MutableLiveData<String>()
    val loginSuccess = MutableLiveData<Boolean>()
    private val codeSent = MutableLiveData<Boolean>()
    private val codeResult = MutableLiveData<ResultState<Unit>>()
    val isOneClick =MutableLiveData<Boolean>(false)

    override fun initData() {
        super.initData()
    }

    fun getCode() {
//        val phoneValue = phone.value?.trim() ?: "18688888888"
        val phoneValue = "18688888888"
        if (phoneValue.isEmpty()&& isOneClick.value == false) {
            toastMsg.value = "请输入手机号"
            return
        }
        if ((phoneValue.length != 11||!isPhoneValid(phoneValue))&& isOneClick.value == false) {
            toastMsg.value = "请输入正确的国内手机号"
            return
        }
        if (isAgreementChecked.value != true) {
            toastMsg.value = "请勾选协议"
            return
        }

        KLog.i("发送验证码请求", "手机号: $phoneValue")
       var map= HashMap<String, Any>()
        map.put("mobile",phoneValue)

        request({ repository.sendCode(map) },{
            KLog.i("验证码请求成功", "响应数据: ")
        },{
            KLog.e("验证码请求失败", "错误码: ${it.code}, 错误信息: ${it.msg}")
        })
        if (codeResult.value is ResultState.Success){

        }

        if (codeResult.value is ResultState.Success) {
            codeSent.value = true
            ARouter.getInstance().build(RouterActivityPath.Sign.VERIFY_CODE).navigation()
        }
    }
    private fun isPhoneValid(phone: String): Boolean {
        // 中国大陆手机号正则
        val regex = Regex("^1[3-9]\\d{9}$")
        return regex.matches(phone)
    }

    fun login() {
        val phoneValue = phone.value?.trim() ?: ""
        val codeValue = smsCode.value?.trim() ?: ""
        if (phoneValue.isEmpty()) {
            toastMsg.value = "请输入手机号"
            return
        }
        if (codeValue.length != 6) {
            toastMsg.value = "请输入6位验证码"
            return
        }

        // TODO: 调用 repository 登录/注册，演示用本地逻辑
        val networkError = false
        if (networkError) {
            toastMsg.value = "网络异常，请稍后再试"
        } else {
            loginSuccess.value = true
            toastMsg.value = "登录成功（如未注册则自动注册）"
        }
    }
    fun setOneClickStatus() {
        isOneClick.value = false
    }
} 