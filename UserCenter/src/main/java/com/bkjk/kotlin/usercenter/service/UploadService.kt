package com.bkjk.kotlin.usercenter.service

import io.reactivex.Observable

interface UploadService {

    /**
     * uploadRepository
     */
    fun getUploadToken(): Observable<String>
}