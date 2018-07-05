package com.bkjk.kotlin.baselibrary.ui.activity

import android.os.Bundle
import com.bkjk.kotlin.baselibrary.common.AppManager
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

open class BaseActivity : RxAppCompatActivity() {

    private val appManager: AppManager = AppManager.instances

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appManager.inputActivityStack(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        appManager.removeActivityStack(this)
    }
}