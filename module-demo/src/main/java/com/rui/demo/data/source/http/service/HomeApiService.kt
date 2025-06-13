package com.rui.demo.data.source.http.service

import com.rui.base.entity.ApiResponse
import com.rui.base.entity.ApiResponseTest
import com.rui.demo.data.bean.JokeInfo
import com.rui.mvvmlazy.http.PagingData
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * ******************************
 * *@Author
 * *date ：
 * *description:接口服务类
 * *******************************
 */
interface HomeApiService {
    @GET("api/getImages")
    suspend fun getJoke(
        @Query("page") page: Int,
        @Query("size") count: Int,
    ): ApiResponse<PagingData<JokeInfo>>
    @GET("https://insdoss.freeapptools.com/api/test")
    suspend fun testApi(
        @Query("q") page: String,
    ): ApiResponseTest<Map<String,String>>
}