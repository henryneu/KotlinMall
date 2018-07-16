package com.bkjk.kotlin.usercenter.service.impl

import com.bkjk.kotlin.baselibrary.ext.convert
import com.bkjk.kotlin.baselibrary.ext.convertBoolean
import com.bkjk.kotlin.usercenter.date.protocol.UserInfo
import com.bkjk.kotlin.usercenter.date.repository.UserRepository
import com.bkjk.kotlin.usercenter.service.UserService
import io.reactivex.Observable
import javax.inject.Inject

class UserServiceImpl @Inject constructor(): UserService {

    @Inject
    lateinit var userRepository : UserRepository

    /**
     * 注册服务
     */
    override fun register(mobilePhone: String, verificationCode: String, pwd: String) : Observable<Boolean> {

        return userRepository.register(mobilePhone, verificationCode, pwd)
                .convertBoolean()
    }

    /**
     * 登录服务
     */
    override fun login(mobilePhone: String, pwd: String, pushId: String): Observable<UserInfo> {
        return userRepository.login(mobilePhone, pwd, pushId).convert()
    }

    /**
     * 忘记密码服务
     */
    override fun forgetPwd(mobilePhone: String, verifyCode: String): Observable<Boolean> {
        return userRepository.forgetPwd(mobilePhone, verifyCode).convertBoolean()
    }

    /**
     * 重置密码服务
     */
    override fun resetPwd(mobilePhone: String, pwd: String): Observable<Boolean> {
        return userRepository.resetPwd(mobilePhone, pwd).convertBoolean()
    }

    /**
     * 修改用户信息服务
     */
    override fun editUser(userIcon: String, userName: String, userGender: String, userSignature: String): Observable<UserInfo> {
        return userRepository.editUser(userIcon, userName, userGender, userSignature).convert()
    }
}