package com.bkjk.kotlin.baselibrary.injection

import java.lang.annotation.Retention
import javax.inject.Scope
import java.lang.annotation.RetentionPolicy.RUNTIME

@Scope
@MustBeDocumented
@Retention(RUNTIME)
annotation class ActivityScope