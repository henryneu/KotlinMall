package com.bkjk.kotlin.baselibrary.ext

import android.view.View
import com.bkjk.kotlin.baselibrary.data.protocol.BaseResp
import com.bkjk.kotlin.baselibrary.rx.BaseFunction
import com.bkjk.kotlin.baselibrary.rx.BaseFunctionBoolean
import com.bkjk.kotlin.baselibrary.rx.BaseObserver
import com.trello.rxlifecycle2.LifecycleProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.execute(observer: BaseObserver<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(lifecycleProvider.bindToLifecycle())
            .subscribe(observer)
}

fun View.onClick(listener: View.OnClickListener) {
    this.setOnClickListener(listener)
}

fun View.onClick(method: () -> Unit) {
    this.setOnClickListener { method() }
}

fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunction())
}

fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFunctionBoolean())
}