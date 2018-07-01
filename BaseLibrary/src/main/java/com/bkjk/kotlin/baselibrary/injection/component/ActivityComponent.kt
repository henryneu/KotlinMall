package com.bkjk.kotlin.baselibrary.injection.component

import android.content.Context
import com.bkjk.kotlin.baselibrary.injection.ActivityScope
import com.bkjk.kotlin.baselibrary.injection.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun context() : Context
}
