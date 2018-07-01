package com.bkjk.kotlin.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.bkjk.kotlin.baselibrary.injection.ActivityScope
import com.bkjk.kotlin.baselibrary.injection.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun activity() : Activity
    // fun context(): Context
}
