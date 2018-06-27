package com.bkjk.kotlin.usercenter.date.protocol

data class RegisterReq(val mobilePhone: String, val verificationCode: String, val pwd: String) {
}