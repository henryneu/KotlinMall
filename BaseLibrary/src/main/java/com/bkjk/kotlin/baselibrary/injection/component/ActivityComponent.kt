package com.bkjk.kotlin.baselibrary.injection.component

import android.app.Activity
import com.bkjk.kotlin.baselibrary.injection.ActivityScope
import com.bkjk.kotlin.baselibrary.injection.module.ActivityModule
import com.bkjk.kotlin.baselibrary.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(ActivityModule::class, LifecycleProviderModule::class))
interface ActivityComponent {

    fun activity() : Activity
    fun lifecycleProvider(): LifecycleProvider<*>
}
