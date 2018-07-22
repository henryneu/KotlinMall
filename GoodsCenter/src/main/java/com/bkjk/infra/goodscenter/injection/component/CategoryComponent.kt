package com.bkjk.infra.goodscenter.injection.component

import com.bkjk.infra.goodscenter.injection.module.CategoryModule
import com.bkjk.infra.goodscenter.ui.fragment.CategoryFragment
import com.bkjk.kotlin.baselibrary.injection.component.ActivityComponent
import com.bkjk.kotlin.baselibrary.injection.module.PerComponentScope
import dagger.Component

@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(CategoryModule::class))
interface CategoryComponent {

    fun inject(fragment: CategoryFragment)
}