package com.bkjk.infra.goodscenter.injection.module

import com.bkjk.infra.goodscenter.service.CategoryService
import com.bkjk.infra.goodscenter.service.impl.CategoryServiceImpl
import dagger.Module
import dagger.Provides

@Module
class CategoryModule {

    @Provides
    fun providesCategoryService(categoryService: CategoryServiceImpl): CategoryService {
        return categoryService
    }
}