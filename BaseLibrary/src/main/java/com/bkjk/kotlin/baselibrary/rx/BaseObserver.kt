package com.bkjk.kotlin.baselibrary.rx

import com.bkjk.kotlin.baselibrary.presenter.view.BaseView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

open class BaseObserver<T>(val baseView: BaseView) : Observer<T> {
    override fun onSubscribe(d: Disposable) {
    }

    override fun onComplete() {
        baseView.hideLoading()
    }

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
        baseView.hideLoading()
    }
}