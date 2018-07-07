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
}