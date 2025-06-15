package com.rui.sign.data.source.http

import com.rui.mvvmlazy.http.BaseResponse
import com.rui.sign.data.source.HttpDataSource
import com.rui.sign.data.source.http.service.SignApiService

/**
 * Created by zjr on 2019/3/26.
 */
class HttpDataSourceImpl(private val apiService: SignApiService) : HttpDataSource {
    override suspend fun sendCode(phone: String): BaseResponse<Unit> = apiService.sendCode(phone)
    override suspend fun verifyCode(phone: String, code: String): BaseResponse<Unit> = apiService.verifyCode(phone, code)
}