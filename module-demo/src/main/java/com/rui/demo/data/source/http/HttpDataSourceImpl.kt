package com.rui.demo.data.source.http

import com.rui.base.entity.ApiResponse
import com.rui.base.entity.ApiResponseTest
import com.rui.demo.data.bean.JokeInfo
import com.rui.demo.data.source.HttpDataSource
import com.rui.demo.data.source.http.service.HomeApiService
import com.rui.mvvmlazy.http.PagingData

/**
 * Created by zjr on 2019/3/26.
 */
class HttpDataSourceImpl(var apiService: HomeApiService) : HttpDataSource {
    override suspend fun getJoke(
        page: Int,
        size: Int
    ): ApiResponse<PagingData<JokeInfo>> {
        return apiService.getJoke(page, size)
    }

    override suspend fun testApi(page: String): ApiResponseTest<Map<String, String>> {
        return apiService.testApi(page)
    }


}