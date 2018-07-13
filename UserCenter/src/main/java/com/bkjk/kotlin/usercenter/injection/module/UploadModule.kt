package com.bkjk.kotlin.usercenter.injection.module

import com.bkjk.kotlin.usercenter.service.UploadService
import com.bkjk.kotlin.usercenter.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UploadModule {

    @Provides
    fun providesUploadService(uploadService: UploadServiceImpl): UploadService {
        return uploadService
    }
}