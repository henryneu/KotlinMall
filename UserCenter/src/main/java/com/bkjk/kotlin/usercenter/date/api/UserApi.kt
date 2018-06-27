package com.bkjk.kotlin.usercenter.date.api

import com.bkjk.kotlin.baselibrary.data.protocol.BaseResp
import com.bkjk.kotlin.usercenter.date.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface UserApi {

    @POST("userCenter/register")
    fun register(@Body req: RegisterReq) : Observable<BaseResp<String>>
}