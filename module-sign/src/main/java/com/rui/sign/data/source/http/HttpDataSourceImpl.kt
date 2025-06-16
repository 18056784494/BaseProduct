package com.rui.sign.data.source.http

import com.rui.base.entity.ApiResponse
import com.rui.mvvmlazy.http.BaseResponse
import com.rui.sign.Login
import com.rui.sign.data.source.HttpDataSource
import com.rui.sign.data.source.http.service.SignApiService

/**
 * Created by zjr on 2019/3/26.
 */
class HttpDataSourceImpl(private val apiService: SignApiService) : HttpDataSource {
    override suspend fun sendCode(mobile: HashMap<String, Any>): ApiResponse<Login> = apiService.sendCode(mobile)
    override suspend fun verifyCode(phone: String, code: String): ApiResponse<String> = apiService.verifyCode(phone, code)
}