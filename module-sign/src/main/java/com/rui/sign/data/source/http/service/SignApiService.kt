package com.rui.sign.data.source.http.service

import com.rui.base.entity.ApiResponse
import com.rui.base.entity.UserProfile
import com.rui.sign.data.bean.Code
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * ******************************
 * *@Author
 * *date ：
 * *description:接口服务类
 * *******************************
 */
interface SignApiService {
//    @FormUrlEncoded
    @POST("api/user/mobile/get-verify-code")
    suspend fun sendCode(@Body params: HashMap<String, Any>): ApiResponse<Code>

//    @FormUrlEncoded
    @POST("api/user/login/mobile")
    suspend fun verifyCode(@Body params: HashMap<String, Any>): ApiResponse<UserProfile>
}