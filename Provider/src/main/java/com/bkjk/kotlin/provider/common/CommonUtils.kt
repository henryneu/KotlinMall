package com.bkjk.kotlin.provider.common

import com.bkjk.kotlin.baselibrary.common.BaseConstant
import com.bkjk.kotlin.baselibrary.utils.SPUtils

fun isLogined(): Boolean {
    return SPUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
}