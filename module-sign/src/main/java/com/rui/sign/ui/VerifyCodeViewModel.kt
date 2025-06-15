package com.rui.sign.ui

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import com.rui.mvvmlazy.base.BaseViewModel
import com.rui.sign.data.repository
import com.rui.mvvmlazy.ext.request
import com.rui.mvvmlazy.state.ResultState

class VerifyCodeViewModel : BaseViewModel() {
    val sendTip = MutableLiveData<String>()
    val resendText = MutableLiveData<String>("重新发送")
    val canResend = MutableLiveData<Boolean>(false)
    val codeResult = MutableLiveData<ResultState<Unit>>()
    val codeInput = MutableLiveData<String>() // 6位验证码
    var phone: String = ""
    private var timer: CountDownTimer? = null

    fun start(phone: String) {
        this.phone = phone
        sendTip.value = "短信验证码已发送至 $phone"
        startTimer()
    }

    fun resendCode() {
        if (canResend.value == true) {
            // 重新发送验证码
            request({ repository.sendCode(phone) }, codeResult)
            startTimer()
        }
    }

    private fun startTimer() {
        canResend.value = false
        timer?.cancel()
        timer = object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                resendText.value = "重新发送(${millisUntilFinished / 1000}s)"
            }
            override fun onFinish() {
                resendText.value = "重新发送"
                canResend.value = true
            }
        }.start()
    }

    fun verifyCodeAndLogin() {
        val code = codeInput.value ?: ""
        if (code.length != 6) return
        // 假设 repository.verifyCode(phone, code) 校验验证码
        request({ repository.verifyCode(phone, code) }, codeResult)
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
} 