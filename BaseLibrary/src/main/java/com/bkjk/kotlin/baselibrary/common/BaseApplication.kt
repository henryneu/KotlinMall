package com.bkjk.kotlin.baselibrary.common

import android.app.Application
import com.bkjk.kotlin.baselibrary.injection.component.AppComponent
import com.bkjk.kotlin.baselibrary.injection.component.DaggerAppComponent
import com.bkjk.kotlin.baselibrary.injection.module.AppModule

class BaseApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initAppInjection()
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}