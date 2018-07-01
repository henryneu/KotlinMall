package com.bkjk.kotlin.usercenter.injection.component

import com.bkjk.kotlin.baselibrary.injection.component.ActivityComponent
import com.bkjk.kotlin.baselibrary.injection.module.PerComponentScope
import com.bkjk.kotlin.usercenter.injection.module.UserModule
import com.bkjk.kotlin.usercenter.ui.activity.RegisterActivity
import dagger.Component

@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(UserModule::class))
interface UserComponent {

    fun inject(activity: RegisterActivity)
}