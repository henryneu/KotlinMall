package com.bkjk.kotlin.usercenter.injection.component

import com.bkjk.kotlin.usercenter.injection.module.UserModule
import com.bkjk.kotlin.usercenter.ui.activity.RegisterActivity
import dagger.Component

@Component(modules = arrayOf(UserModule::class))
interface UserComponent {

    fun inject(activity: RegisterActivity)
}