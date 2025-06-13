package com.rui.demo.data.source

import com.rui.base.entity.ApiResponse
import com.rui.base.entity.ApiResponseTest
import com.rui.demo.data.bean.JokeInfo
import com.rui.mvvmlazy.http.PagingData
import retrofit2.http.Query

/**
 * Created by zjr on 2019/3/26.
 */
interface HttpDataSource {
    suspend  fun getJoke(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): ApiResponse<PagingData<JokeInfo>>
    suspend  fun testApi(
        @Query("q") page: String
    ):ApiResponseTest<Map<String,String>>
}