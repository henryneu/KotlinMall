package com.bkjk.kotlin.usercenter.date.repository

import com.bkjk.kotlin.baselibrary.data.net.RetrofitFactory
import com.bkjk.kotlin.baselibrary.data.protocol.BaseResp
import com.bkjk.kotlin.usercenter.date.api.UserApi
import com.bkjk.kotlin.usercenter.date.protocol.LoginReq
import com.bkjk.kotlin.usercenter.date.protocol.RegisterReq
import com.bkjk.kotlin.usercenter.date.protocol.UserInfo
import io.reactivex.Observable
import javax.inject.Inject

class UserRepository @Inject constructor() {

    /**
     * 注册服务
     */
    fun register(mobilePhone:String, verificationCode: String, pwd: String) :Observable<BaseResp<String>> {
        return RetrofitFactory.instances.create(UserApi::class.java)
                .register(RegisterReq(mobilePhone, verificationCode, pwd))
    }

    /**
     * 登录服务
     */
    fun login(mobilePhone:String, pwd: String, pushId: String) :Observable<BaseResp<UserInfo>> {
        return RetrofitFactory.instances.create(UserApi::class.java)
                .login(LoginReq(mobilePhone, pwd, pushId))
    }
}