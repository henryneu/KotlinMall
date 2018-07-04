package com.bkjk.kotlin.baselibrary.injection.module

import java.lang.annotation.Retention
import javax.inject.Scope
import java.lang.annotation.RetentionPolicy.RUNTIME

@Scope
@MustBeDocumented
@Retention(RUNTIME)
annotation class PerComponentScope