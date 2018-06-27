package com.bkjk.kotlin.usercenter.date.repository

import com.bkjk.kotlin.baselibrary.data.net.RetrofitFactory
import com.bkjk.kotlin.baselibrary.data.protocol.BaseResp
import com.bkjk.kotlin.usercenter.date.api.UserApi
import com.bkjk.kotlin.usercenter.date.protocol.RegisterReq
import io.reactivex.Observable

class UserRepository {

    fun register(mobilePhone:String, verificationCode: String, pwd: String) :Observable<BaseResp<String>> {
        return RetrofitFactory.instances.create(UserApi::class.java)
                .register(RegisterReq(mobilePhone, verificationCode, pwd))
    }
}