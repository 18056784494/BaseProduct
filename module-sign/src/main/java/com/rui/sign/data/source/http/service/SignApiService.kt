package com.rui.sign.data.source.http.service

import com.rui.base.entity.ApiResponse
import com.rui.mvvmlazy.http.PagingData
import com.rui.sign.Login
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

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
    suspend fun sendCode(@Body params: HashMap<String, Any>): ApiResponse<Login>

    @FormUrlEncoded
    @POST("/api/verifyCode")
    suspend fun verifyCode(@Field("phone") phone: String, @Field("code") code: String): ApiResponse<String>
}