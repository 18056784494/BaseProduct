package com.rui.sign.data.source

import com.rui.base.entity.ApiResponse
import com.rui.mvvmlazy.http.BaseResponse
import com.rui.sign.Login

/**
 * Created by zjr on 2019/3/26.
 */
interface HttpDataSource {
    suspend fun sendCode(phone: HashMap<String, Any>): ApiResponse<Login>
    suspend fun verifyCode(phone: String, code: String): ApiResponse<String>
} 