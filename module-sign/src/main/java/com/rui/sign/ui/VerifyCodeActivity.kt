package com.rui.sign.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
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

@Route(path = RouterActivityPath.Sign.VERIFY_CODE)
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
            val currentEditText = codeInputs[i]

            currentEditText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    // 输入一个字符时，焦点向前移动
                    if (s?.length == 1) {
                        if (i < codeInputs.size - 1) {
                            codeInputs[i + 1].requestFocus()
                        } else {
                            // 输入所有6位数字后，触发验证
                            val code = codeInputs.joinToString("") { it.text.toString() }
                            viewModel.codeInput.value = code
                            viewModel.verifyCodeAndLogin()
                        }
                    }
                    // 始终更新 ViewModel 的完整验证码，尤其是在用户删除中间字符时很重要
                    val fullCode = codeInputs.joinToString("") { it.text.toString() }
                    viewModel.codeInput.value = fullCode
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })

            // 添加 OnKeyListener 处理退格键以删除并向后移动焦点
            currentEditText.setOnKeyListener { v, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN) {
                    // 如果当前 EditText 为空且不是第一个
                    if (currentEditText.text.isEmpty() && i > 0) {
                        codeInputs[i - 1].setText("") // 清除上一个 EditText 的内容
                        codeInputs[i - 1].requestFocus() // 将焦点移动到上一个 EditText
                        return@setOnKeyListener true // 消耗事件以防止默认系统行为
                    }
                }
                false // 让其他按键事件（包括非空字段上的退格键，它会清除内容）由默认处理
            }
        }
    }

    private fun observeViewModel() {
        viewModel.codeResult.observe(this, Observer { resultState ->
            parseState(resultState, {
                // 验证码校验成功，跳转主页
                ToastUtils.showShort("登录成功")
                // TODO: 跳转主页
                // 示例: ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN).navigation()
                // finish()
            }, {
                // 验证码校验失败
                ToastUtils.showShort("验证码无效，请重新输入")
                codeInputs.forEach { it.setText("") } // 清除所有输入
                codeInputs[0].requestFocus() // 聚焦到第一个输入框
            })
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // 返回登录页
        // 示例: ARouter.getInstance().build(RouterActivityPath.Sign.PAGER_MOBILE_LOGIN).navigation()
        finish()
    }
} 