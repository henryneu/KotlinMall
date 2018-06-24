package com.bkjk.kotlin.baselibrary.presenter.view

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError()
}