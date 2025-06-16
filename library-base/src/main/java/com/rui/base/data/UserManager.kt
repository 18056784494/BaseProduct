package com.rui.base.data

import com.rui.base.entity.UserProfile
import com.rui.base.entity.Profile
import com.tencent.mmkv.MMKV
import com.rui.mvvmlazy.utils.common.KLog
import com.rui.mvvmlazy.utils.common.ToastUtils

/**
 * 用户数据管理类
 */
object UserManager {
    private const val TAG = "UserManager"
    private val mmkv: MMKV by lazy {
        MMKV.mmkvWithID("user_data")
    }

    /**
     * 保存用户数据
     */
    fun saveUserProfile(userProfile: UserProfile) {
        try {
            mmkv.encode("user_profile", userProfile)
            KLog.i(TAG, "用户数据保存成功")
        } catch (e: Exception) {
            KLog.e(TAG, "用户数据保存失败: ${e.message}")
            ToastUtils.showShort("用户数据保存失败")
        }
    }

    /**
     * 获取用户数据
     */
    fun getUserProfile(): UserProfile? {
        return try {
            mmkv.decodeParcelable("user_profile", UserProfile::class.java)
        } catch (e: Exception) {
            KLog.e(TAG, "获取用户数据失败: ${e.message}")
            null
        }
    }

    /**
     * 清除用户数据
     */
    fun clearUserProfile() {
        try {
            mmkv.remove("user_profile")
            KLog.i(TAG, "用户数据清除成功")
        } catch (e: Exception) {
            KLog.e(TAG, "用户数据清除失败: ${e.message}")
            ToastUtils.showShort("用户数据清除失败")
        }
    }

    /**
     * 获取用户token
     */
    fun getToken(): String {
        return getUserProfile()?.token ?: ""
    }

    /**
     * 判断用户是否已登录
     */
    fun isLoggedIn(): Boolean {
        return getUserProfile() != null
    }

    /**
     * 获取用户名
     */
    fun getUsername(): String {
        return getUserProfile()?.profile?.username ?: ""
    }

    /**
     * 获取头像URL
     */
    fun getAvatar(): String {
        return getUserProfile()?.profile?.avatar ?: ""
    }

    /**
     * 获取性别
     */
    fun getSex(): String {
        return getUserProfile()?.profile?.sex ?: ""
    }

    /**
     * 获取生日
     */
    fun getBirthday(): String {
        return getUserProfile()?.profile?.birthday ?: ""
    }

    /**
     * 获取MBTI
     */
    fun getMbti(): String {
        return getUserProfile()?.profile?.mbti ?: ""
    }

    /**
     * 获取标签
     */
    fun getTags(): String {
        return getUserProfile()?.profile?.tags ?: ""
    }

    /**
     * 判断用户是否已初始化
     */
    fun isInitialized(): Boolean {
        return getUserProfile()?.profile?.initialized == "1"
    }

    /**
     * 更新用户信息
     */
    fun updateProfile(update: (Profile) -> Profile) {
        try {
            val userProfile = getUserProfile()
            if (userProfile != null) {
                val updatedProfile = update(userProfile.profile)
                saveUserProfile(userProfile.copy(profile = updatedProfile))
                KLog.i(TAG, "用户数据更新成功")
            } else {
                KLog.e(TAG, "用户数据不存在，无法更新")
            }
        } catch (e: Exception) {
            KLog.e(TAG, "用户数据更新失败: ${e.message}")
        }
    }

    /**
     * 更新用户名
     */
    fun updateUsername(username: String) {
        updateProfile { profile ->
            profile.copy(username = username)
        }
    }

    /**
     * 更新头像
     */
    fun updateAvatar(avatar: String) {
        updateProfile { profile ->
            profile.copy(avatar = avatar)
        }
    }

    /**
     * 更新性别
     */
    fun updateSex(sex: String) {
        updateProfile { profile ->
            profile.copy(sex = sex)
        }
    }

    /**
     * 更新生日
     */
    fun updateBirthday(birthday: String) {
        updateProfile { profile ->
            profile.copy(birthday = birthday)
        }
    }

    /**
     * 更新MBTI
     */
    fun updateMbti(mbti: String) {
        updateProfile { profile ->
            profile.copy(mbti = mbti)
        }
    }

    /**
     * 更新标签
     */
    fun updateTags(tags: String) {
        updateProfile { profile ->
            profile.copy(tags = tags)
        }
    }

    /**
     * 设置用户初始化状态
     */
    fun setInitialized(initialized: Boolean) {
        updateProfile { profile ->
            profile.copy(initialized = if (initialized) "1" else "0")
        }
    }
} 