package com.bkjk.kotlin.baselibrary.widgets

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.widget.Button
import com.bkjk.kotlin.baselibrary.R

/**
 * 获取验证码 Button
 */
class VerifyButton(mContext: Context, attrs: AttributeSet): Button(mContext, attrs) {

    private val mHandler: Handler
    private var mCount = 60
    private var mOnVerifyBtnClick: OnVerifyBtnClick? = null

    init {
        this.text = resources.getString(R.string.base_verification_code)
        mHandler = Handler()
    }

    /**
     * 倒计时，并处理点击事件
     */
    fun requestSendVerifyNumber() {
        mHandler.postDelayed(countDown, 0)
        if (mOnVerifyBtnClick != null) {
            mOnVerifyBtnClick!!.onClick()
        }
    }

    /**
     * 倒计时
     */
    private val countDown = object: Runnable {
        override fun run() {
            this@VerifyButton.text = mCount.toString() + "s "
            this@VerifyButton.setBackgroundColor(resources.getColor(R.color.common_disable))
            this@VerifyButton.setTextColor(resources.getColor(R.color.common_white))
            this@VerifyButton.isEnabled = false

            if (mCount > 0) {
                mHandler.postDelayed(this, 1000)
            } else {
                resetCounter()
            }
            mCount--
        }
    }

    /**
     * 恢复到初始状态
     */
    fun resetCounter(vararg text: String) {
        this.isEnabled = true
        if (text.isNotEmpty() && "" != text[0]) {
            this.text = text[0]
        } else {
            this.text = resources.getString(R.string.base_re_verification_code)
        }
        this.setBackgroundColor(resources.getColor(R.color.transparent))
        this.setTextColor(resources.getColor(R.color.common_blue))
        mCount = 60
    }

    /**
     * 点击事件接口
     */
    interface OnVerifyBtnClick {
        fun onClick()
    }

    /**
     * 设置点击事件监听
     */
    fun setOnVerifyBtnClick(onVerifyBtnClick: OnVerifyBtnClick) {
        this.mOnVerifyBtnClick = onVerifyBtnClick
    }
}