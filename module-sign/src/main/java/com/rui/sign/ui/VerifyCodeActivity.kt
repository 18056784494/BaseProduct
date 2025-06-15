package com.rui.sign.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.rui.base.router.RouterActivityPath
import com.rui.sign.BR
import com.rui.sign.R
import com.rui.sign.databinding.ActivityVerifyCodeBinding
import com.rui.mvvmlazy.base.activity.BaseVmDbActivity
import com.rui.mvvmlazy.ext.parseState
import com.rui.mvvmlazy.utils.common.ToastUtils

@Route(path = RouterActivityPath.Sign.PAGER_VERIFY_CODE)
class VerifyCodeActivity : BaseVmDbActivity<VerifyCodeViewModel, ActivityVerifyCodeBinding>() {
    private lateinit var codeInputs: List<EditText>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 获取手机号参数
        val phone = intent.getStringExtra("phone") ?: ""
        viewModel.start(phone)
        setupCodeInputs()
        observeViewModel()
    }

    override fun initContentView(): Int = R.layout.activity_verify_code
    override fun initVariableId(): Int = BR.viewModel

    private fun setupCodeInputs() {
        codeInputs = listOf(
            binding.etCode0, binding.etCode1, binding.etCode2,
            binding.etCode3, binding.etCode4, binding.etCode5
        )
        for (i in codeInputs.indices) {
            codeInputs[i].addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    if (s?.length == 1 && i < codeInputs.size - 1) {
                        codeInputs[i + 1].requestFocus()
                    }
                    if (s?.isEmpty() == true && i > 0) {
                        codeInputs[i - 1].requestFocus()
                    }
                    // 拼接所有输入
                    val code = codeInputs.joinToString("") { it.text.toString() }
                    if (code.length == 6) {
                        viewModel.codeInput.value = code
                        viewModel.verifyCodeAndLogin()
                    }
                }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })
        }
    }

    private fun observeViewModel() {
        viewModel.codeResult.observe(this, Observer { resultState ->
            parseState(resultState, {
                // 验证码校验成功，跳转主页
                ToastUtils.showShort("登录成功")
                // TODO: 跳转主页
            }, {
                // 验证码校验失败
                ToastUtils.showShort("验证码无效，请重新输入")
                codeInputs.forEach { it.setText("") }
                codeInputs[0].requestFocus()
            })
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // 返回登录页
        finish()
    }
} 