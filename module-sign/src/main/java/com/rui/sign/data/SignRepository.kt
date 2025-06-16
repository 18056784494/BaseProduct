package com.rui.sign.data

import com.rui.base.entity.ApiResponse
import com.rui.base.entity.UserProfile
import com.rui.base.network.RetrofitClient
import com.rui.mvvmlazy.base.BaseModel
import com.rui.sign.data.bean.Code
import com.rui.sign.data.source.HttpDataSource
import com.rui.sign.data.source.http.HttpDataSourceImpl
import com.rui.sign.data.source.http.service.SignApiService

/**
 * ******************************
 * *@Author
 * *date ：
 * *description:MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 * *******************************
 */
val repository: SignRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    SignRepository()
}

class SignRepository : BaseModel(), HttpDataSource {
    private val mHttpDataSource by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        HttpDataSourceImpl(
            RetrofitClient.instance.create(
                SignApiService::class.java
            )
        )
    }

    override suspend fun sendCode(map: HashMap<String, Any>): ApiResponse<Code> = mHttpDataSource.sendCode(map)
    override suspend fun verifyCode(map: HashMap<String, Any>): ApiResponse<UserProfile> = mHttpDataSource.verifyCode(map)
}