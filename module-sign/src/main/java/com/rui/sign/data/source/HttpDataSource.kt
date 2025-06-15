package com.rui.sign.data.source

import com.rui.mvvmlazy.http.BaseResponse

/**
 * Created by zjr on 2019/3/26.
 */
interface HttpDataSource {
    suspend fun sendCode(phone: String): BaseResponse<Unit>
    suspend fun verifyCode(phone: String, code: String): BaseResponse<Unit>
} 