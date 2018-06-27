package com.bkjk.kotlin.baselibrary.ext

import com.bkjk.kotlin.baselibrary.rx.BaseObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.execute(subscriber: BaseObserver<T>) {
    this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)
}