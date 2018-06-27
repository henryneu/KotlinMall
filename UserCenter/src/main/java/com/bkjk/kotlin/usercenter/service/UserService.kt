package com.bkjk.kotlin.usercenter.service

import io.reactivex.Observable

interface UserService {
    fun register(mobilePhone:String, verificationCode: String, pwd: String): Observable<Boolean>
}