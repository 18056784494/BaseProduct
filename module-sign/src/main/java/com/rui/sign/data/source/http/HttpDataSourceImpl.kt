package com.rui.sign.data.source.http

import com.rui.base.entity.ApiResponse
import com.rui.sign.data.bean.Code
import com.rui.sign.data.bean.UserProfile
import com.rui.sign.data.source.HttpDataSource
import com.rui.sign.data.source.http.service.SignApiService

/**
 * Created by zjr on 2019/3/26.
 */
class HttpDataSourceImpl(private val apiService: SignApiService) : HttpDataSource {
    override suspend fun sendCode(map: HashMap<String, Any>): ApiResponse<Code> = apiService.sendCode(map)
    override suspend fun verifyCode(map: HashMap<String, Any>): ApiResponse<UserProfile> = apiService.verifyCode(map)
}