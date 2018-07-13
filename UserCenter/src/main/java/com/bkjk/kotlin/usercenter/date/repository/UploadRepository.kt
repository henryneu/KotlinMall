package com.bkjk.kotlin.usercenter.date.repository

import com.bkjk.kotlin.baselibrary.data.net.RetrofitFactory
import com.bkjk.kotlin.baselibrary.data.protocol.BaseResp
import com.bkjk.kotlin.usercenter.date.api.UploadApi
import io.reactivex.Observable
import javax.inject.Inject

class UploadRepository @Inject constructor() {

    /**
     * 获取上传所需 Token 凭证
     */
    fun getUploadToken() :Observable<BaseResp<String>> {
        return RetrofitFactory.instances.create(UploadApi::class.java)
                .getUploadToken()
    }
}