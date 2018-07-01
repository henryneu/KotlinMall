package com.bkjk.kotlin.usercenter.injection.module

import com.bkjk.kotlin.usercenter.service.UserService
import com.bkjk.kotlin.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    fun providesUserService(service: UserServiceImpl): UserService {
        return service;
    }
}