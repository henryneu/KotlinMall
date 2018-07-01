package com.bkjk.kotlin.baselibrary.injection.module

import android.content.Context
import com.bkjk.kotlin.baselibrary.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: BaseApplication) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return context
    }
}