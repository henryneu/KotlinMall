package com.bkjk.kotlin.usercenter.service

import rx.Observable

interface UserService {
    fun register(mobilePhone:String, verificationCode: String, pwd: String): Observable<Boolean>
}