package com.bkjk.kotlin.usercenter.date.api

import com.bkjk.kotlin.baselibrary.data.protocol.BaseResp
import com.bkjk.kotlin.usercenter.date.protocol.*
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

    /**
     * 忘记密码服务
     */
    @POST("userCenter/forgetPwd")
    fun forgetPwd(@Body req: ForgetPwdReq) : Observable<BaseResp<String>>

    /**
     * 重置密码服务
     */
    @POST("userCenter/resetPwd")
    fun resetPwd(@Body req: ResetPwdReq) : Observable<BaseResp<String>>

    /**
     * 修改用户信息服务
     */
    @POST("usercenter/editUser")
    fun editUser(@Body req: EditUserInfoReq) : Observable<BaseResp<UserInfo>>
}