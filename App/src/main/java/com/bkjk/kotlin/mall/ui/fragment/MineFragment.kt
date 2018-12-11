package com.bkjk.kotlin.mall.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bkjk.kotlin.baselibrary.ext.loadUrl
import com.bkjk.kotlin.baselibrary.ext.onClick
import com.bkjk.kotlin.baselibrary.ui.fragment.BaseFragment
import com.bkjk.kotlin.baselibrary.utils.SPUtils
import com.bkjk.kotlin.mall.R
import com.bkjk.kotlin.mall.ui.activity.SettingActivity
import com.bkjk.kotlin.provider.common.ProviderConstant
import com.bkjk.kotlin.provider.common.isLogined
import com.bkjk.kotlin.usercenter.ui.activity.LoginActivity
import com.bkjk.kotlin.usercenter.ui.activity.UserInfoActivity
import kotlinx.android.synthetic.main.layout_fragment_mine.*
import org.jetbrains.anko.support.v4.startActivity

class MineFragment : BaseFragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.layout_fragment_mine, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onStart() {
        super.onStart()
        loadDate()
    }

    private fun loadDate() {
        if (isLogined()) {
            val userIcon = SPUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
            if (userIcon.isNotEmpty()) {
                mUserIconIv.loadUrl(userIcon)
            }
            mUserNameTv.text = SPUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
        } else {
            mUserIconIv.setImageResource(R.drawable.default_user_icon)
            mUserNameTv.text = getString(R.string.mine_un_login_text)
        }
    }

    private fun initView() {
        mUserIconIv.onClick(this)
        mUserNameTv.onClick(this)
        mSettingTv.onClick(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.mUserIconIv, R.id.mUserNameTv -> {
                if (isLogined()) {
                    startActivity<UserInfoActivity>()
                } else {
                    startActivity<LoginActivity>()
                }
            }
            R.id.mSettingTv -> {
                startActivity<SettingActivity>()
            }
        }
    }
}