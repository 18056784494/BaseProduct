package com.rui.sign.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.rui.base.router.RouterActivityPath
import com.rui.sign.BR
import com.rui.sign.R
import com.rui.sign.databinding.ActivityLoginBinding
import com.rui.mvvmlazy.base.activity.BaseVmDbActivity

@Route(path = RouterActivityPath.Sign.PAGER_MOBILE_LOGIN)
class LoginActivity : BaseVmDbActivity<LoginViewModel, ActivityLoginBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initContentView(): Int = R.layout.activity_login

    override fun initVariableId(): Int = BR.viewModel

    override fun initData() {
        super.initData()
        viewModel.toastMsg.observe(this, Observer {
            it?.let { showToast(it) }
        })
        viewModel.loginSuccess.observe(this, Observer {
            if (it == true) finish()
        })
    }

    private fun showToast(msg: String) {
        android.widget.Toast.makeText(this, msg, android.widget.Toast.LENGTH_SHORT).show()
    }
} 