package com.bkjk.kotlin.mall.ui.activity

import android.os.Bundle
import com.bkjk.kotlin.baselibrary.ext.onClick
import com.bkjk.kotlin.baselibrary.ui.activity.BaseActivity
import com.bkjk.kotlin.mall.R
import com.bkjk.kotlin.usercenter.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        mLogoutBtn.onClick {
            UserPrefsUtils.putUserInfo(null)
            finish()
        }
    }
}
