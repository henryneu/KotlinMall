package com.bkjk.kotlin.baselibrary.injection.component

import android.content.Context
import com.bkjk.kotlin.baselibrary.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun context() : Context
}