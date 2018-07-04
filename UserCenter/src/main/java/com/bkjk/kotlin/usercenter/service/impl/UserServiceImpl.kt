package com.bkjk.kotlin.usercenter.service.impl

import com.bkjk.kotlin.baselibrary.ext.convertBoolean
import com.bkjk.kotlin.usercenter.date.repository.UserRepository
import com.bkjk.kotlin.usercenter.service.UserService
import io.reactivex.Observable
import javax.inject.Inject

class UserServiceImpl @Inject constructor(): UserService {

    @Inject
    lateinit var userRepository : UserRepository

    override fun register(mobilePhone: String, verificationCode: String, pwd: String) : Observable<Boolean> {

        return userRepository.register(mobilePhone, verificationCode, pwd)
                .convertBoolean()
    }
}