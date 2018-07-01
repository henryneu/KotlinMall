package com.bkjk.kotlin.usercenter.service.impl

import com.bkjk.kotlin.baselibrary.data.protocol.BaseResp
import com.bkjk.kotlin.baselibrary.rx.BaseException
import com.bkjk.kotlin.usercenter.date.repository.UserRepository
import com.bkjk.kotlin.usercenter.service.UserService
import io.reactivex.Observable
import io.reactivex.functions.Function
import javax.inject.Inject

class UserServiceImpl @Inject constructor(): UserService {

    @Inject
    lateinit var userRepository : UserRepository

    override fun register(mobilePhone: String, verificationCode: String, pwd: String) : Observable<Boolean> {

        return userRepository.register(mobilePhone, verificationCode, pwd)
                .flatMap(object : Function<BaseResp<String>, Observable<Boolean>> {
                    override fun apply(t: BaseResp<String>): Observable<Boolean> {
                        if (t.status != 0) {
                            return Observable.error(BaseException(t.status, t.message))
                        }
                        return Observable.just(true)
                    }
                })
    }
}