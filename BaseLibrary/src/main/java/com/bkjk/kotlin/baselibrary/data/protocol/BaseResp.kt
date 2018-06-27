package com.bkjk.kotlin.baselibrary.data.protocol

/**
 * 响应接收类
 */
class BaseResp<out T> (val status: Int, val message: String, val data: T)