package com.bkjk.kotlin.usercenter.utils

import com.bkjk.kotlin.baselibrary.common.BaseConstant
import com.bkjk.kotlin.baselibrary.utils.SPUtils
import com.bkjk.kotlin.provider.common.ProviderConstant
import com.bkjk.kotlin.usercenter.date.protocol.UserInfo

/**
 * 本地存储用户相关信息
 */
object UserPrefsUtils {

    /**
     * 退出登录时，传入null,清空存储
     */
    fun putUserInfo(userInfo: UserInfo?) {
        SPUtils.putString(BaseConstant.KEY_SP_TOKEN, userInfo?.id ?: "")
        SPUtils.putString(ProviderConstant.KEY_SP_USER_ICON, userInfo?.userIcon ?: "")
        SPUtils.putString(ProviderConstant.KEY_SP_USER_NAME, userInfo?.userName ?: "")
        SPUtils.putString(ProviderConstant.KEY_SP_USER_MOBILE, userInfo?.userMobile ?: "")
        SPUtils.putString(ProviderConstant.KEY_SP_USER_GENDER, userInfo?.userGender ?: "")
        SPUtils.putString(ProviderConstant.KEY_SP_USER_SIGNATURE, userInfo?.userSign ?: "")
    }
}