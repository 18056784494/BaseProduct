package com.rui.sign.data.source

import com.rui.base.entity.ApiResponse
import com.rui.base.entity.UserProfile
import com.rui.sign.data.bean.Code

/**
 * Created by zjr on 2019/3/26.
 */
interface HttpDataSource {
    suspend fun sendCode(phone: HashMap<String, Any>): ApiResponse<Code>
    suspend fun verifyCode(phone: HashMap<String, Any>): ApiResponse<UserProfile>
}