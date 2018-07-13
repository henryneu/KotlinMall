package com.bkjk.kotlin.usercenter.presenter.view

import com.bkjk.kotlin.baselibrary.presenter.view.BaseView
import com.bkjk.kotlin.usercenter.date.protocol.UserInfo

interface UserInfoView: BaseView {
    /**
     * 获取上传所需 Token 凭证
     */
    fun onGetUploadTokenResult(result:String)

    /**
     * 编辑用户资料回调
     */
    fun onEditUserResult(result: UserInfo)
}