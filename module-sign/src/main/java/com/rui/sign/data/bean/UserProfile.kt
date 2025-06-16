package com.rui.sign.data.bean

data class Code(var codeId: String?) // 验证码ID


/**
 * 用户信息数据类
 */
data class UserProfile(
    val token: String,           // 用户token
    val profile: Profile,        // 用户详细信息
)

/**
 * 用户详细信息数据类
 */
data class Profile(
    val username: String,        // 用户名
    val avatar: String,          // 头像URL
    val sex: String,             // 性别
    val birthday: String,        // 生日
    val mbti: String,            // MBTI性格类型
    val tags: String,            // 用户标签
    val initialized: String      // 是否已初始化
) 