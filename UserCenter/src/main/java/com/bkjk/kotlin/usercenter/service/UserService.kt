package com.bkjk.kotlin.usercenter.service

import com.bkjk.kotlin.usercenter.date.protocol.UserInfo
import io.reactivex.Observable

interface UserService {

    /**
     * 注册服务
     */
    fun register(mobilePhone:String, verificationCode: String, pwd: String): Observable<Boolean>

    /**
     * 登录服务
     */
    fun login(mobilePhone:String, pwd: String, pushId: String): Observable<UserInfo>
}