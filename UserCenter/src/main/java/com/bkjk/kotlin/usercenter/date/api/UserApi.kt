package com.bkjk.kotlin.usercenter.date.api

import com.bkjk.kotlin.baselibrary.data.protocol.BaseResp
import com.bkjk.kotlin.usercenter.date.protocol.LoginReq
import com.bkjk.kotlin.usercenter.date.protocol.RegisterReq
import com.bkjk.kotlin.usercenter.date.protocol.UserInfo
import retrofit2.http.Body
import retrofit2.http.POST
import io.reactivex.Observable

interface UserApi {

    /**
     * 注册服务
     */
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq) : Observable<BaseResp<String>>

    /**
     * 登录服务
     */
    @POST("userCenter/login")
    fun login(@Body req: LoginReq) : Observable<BaseResp<UserInfo>>
}