package com.rui.base.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * 用户信息数据类
 */
@Parcelize
data class UserProfile(
    val token: String,           // 用户token
    val profile: Profile,        // 用户详细信息
) : Parcelable

/**
 * 用户详细信息数据类
 */
@Parcelize
data class Profile(
    val username: String,        // 用户名
    val avatar: String,          // 头像URL
    val sex: String,             // 性别
    val birthday: String,        // 生日
    val mbti: String,            // MBTI性格类型
    val tags: String,            // 用户标签
    val initialized: String      // 是否已初始化
) : Parcelable 