package com.rui.sign.data.source.http.service

import com.rui.mvvmlazy.http.BaseResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * ******************************
 * *@Author
 * *date ：
 * *description:接口服务类
 * *******************************
 */
interface SignApiService {
    @FormUrlEncoded
    @POST("/api/sendCode")
    suspend fun sendCode(@Field("phone") phone: String): BaseResponse<Unit>

    @FormUrlEncoded
    @POST("/api/verifyCode")
    suspend fun verifyCode(@Field("phone") phone: String, @Field("code") code: String): BaseResponse<Unit>
}