package com.bkjk.kotlin.usercenter.service.impl

import com.bkjk.kotlin.usercenter.service.UserService
import io.reactivex.Observable

class UserServiceImpl: UserService {
    override fun register(mobilePhone: String, verificationCode: String, pwd: String) : Observable<Boolean> {
        return Observable.just(true)
    }
}