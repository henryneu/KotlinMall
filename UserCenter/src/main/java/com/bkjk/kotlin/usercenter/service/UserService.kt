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

    /**
     * 忘记密码服务
     */
    fun forgetPwd(mobilePhone:String, verifyCode: String): Observable<Boolean>

    /**
     * 重置密码服务
     */
    fun resetPwd(mobilePhone:String, pwd: String): Observable<Boolean>

    /**
     * 修改用户信息服务
     */
    fun editUser(userIcon: String, userName: String, userGender: String, userSignature: String): Observable<UserInfo>
}