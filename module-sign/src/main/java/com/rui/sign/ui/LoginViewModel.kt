package com.rui.sign.ui

import androidx.lifecycle.MutableLiveData
import com.alibaba.android.arouter.launcher.ARouter
import com.google.gson.Gson
import com.rui.base.router.RouterActivityPath
import com.rui.mvvmlazy.base.BaseViewModel
import com.rui.sign.data.repository
import com.rui.mvvmlazy.ext.request
import com.rui.mvvmlazy.ext.requestNoCheck
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


    fun getCode() {// 发送验证码
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
        map["mobile"] = phoneValue
        requestNoCheck({ repository.sendCode(map) },{
            // 直接获取ApiResponse数据
            KLog.i("验证码请求结果", "响应码: ${it.code}, 响应消息: ${it.msg}, 响应数据: ${Gson().toJson(it.data)}")
            ARouter.getInstance().build(RouterActivityPath.Sign.VERIFY_CODE).withString("codeId","11111111").withString("phone",phoneValue).navigation()
        },{
            // 处理网络异常等错误
            KLog.e("验证码请求异常", "错误信息: ${it.msg}")
        }, isShowDialog = true, loadingMessage = "加载中,请稍后..")

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

    fun setOneClickStatus() {
        isOneClick.value = false
    }
} 