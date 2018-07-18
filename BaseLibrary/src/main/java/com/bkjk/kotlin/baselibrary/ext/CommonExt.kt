package com.bkjk.kotlin.baselibrary.ext

import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.bkjk.kotlin.baselibrary.data.protocol.BaseResp
import com.bkjk.kotlin.baselibrary.rx.BaseFunction
import com.bkjk.kotlin.baselibrary.rx.BaseFunctionBoolean
import com.bkjk.kotlin.baselibrary.rx.BaseObserver
import com.bkjk.kotlin.baselibrary.utils.GlideUtils
import com.bkjk.kotlin.baselibrary.widgets.DefaultTextWatcher
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

fun Button.enable(editText: EditText, method: () -> Boolean) {
    val mRegisterBtn = this
    editText.addTextChangedListener(object: DefaultTextWatcher() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            mRegisterBtn.isEnabled = method()
        }
    })
}

/**
 * ImageView 加载网络图片
 */
fun ImageView.loadUrl(url: String) {
    GlideUtils.loadUrlImage(context, url, this)
}