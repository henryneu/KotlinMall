package com.bkjk.kotlin.usercenter.service.impl

import com.bkjk.kotlin.baselibrary.ext.convert
import com.bkjk.kotlin.usercenter.date.repository.UploadRepository
import com.bkjk.kotlin.usercenter.service.UploadService
import io.reactivex.Observable
import javax.inject.Inject

class UploadServiceImpl @Inject constructor(): UploadService {

    @Inject
    lateinit var uploadRepository : UploadRepository

    /**
     * 获取上传所需 Token 凭证
     */
    override fun getUploadToken(): Observable<String> {
        return uploadRepository.getUploadToken()
                .convert()
    }
}