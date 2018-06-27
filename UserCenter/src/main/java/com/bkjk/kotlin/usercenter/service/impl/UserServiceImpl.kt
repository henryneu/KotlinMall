package com.bkjk.kotlin.usercenter.service.impl

import com.bkjk.kotlin.baselibrary.data.protocol.BaseResp
import com.bkjk.kotlin.baselibrary.rx.BaseException
import com.bkjk.kotlin.usercenter.date.repository.UserRepository
import com.bkjk.kotlin.usercenter.service.UserService
import rx.Observable
import rx.functions.Func1

class UserServiceImpl: UserService {
    override fun register(mobilePhone: String, verificationCode: String, pwd: String) : Observable<Boolean> {
        val userRepository = UserRepository()

        return userRepository.register(mobilePhone, verificationCode, pwd)
                .flatMap(object :Func1<BaseResp<String>, Observable<Boolean>> {
                    override fun call(t: BaseResp<String>): Observable<Boolean> {
                        if (t.status != 0) {
                            return Observable.error(BaseException(t.status, t.message))
                        }
                        return Observable.just(true)
                    }
                })
    }
}