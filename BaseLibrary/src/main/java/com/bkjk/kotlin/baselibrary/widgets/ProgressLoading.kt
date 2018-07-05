package com.bkjk.kotlin.baselibrary.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.widget.ImageView
import com.bkjk.kotlin.baselibrary.R
import org.jetbrains.anko.find

/**
 * 封装加载对话框
 */
class ProgressLoading private constructor(context: Context, theme: Int): Dialog(context, theme) {

    companion object {
        private lateinit var mDialog: ProgressLoading
        private lateinit var mDrawable: AnimationDrawable

        /**
         * 创建加载对话框
         */
        fun create(context: Context): ProgressLoading {
            /** 加载对话框样式 */
            mDialog = ProgressLoading(context, R.style.LightProgressDialog)
            /** 加载对话框布局 */
            mDialog.setContentView(R.layout.progress_loading)

            mDialog.setCancelable(true)
            mDialog.setCanceledOnTouchOutside(false)
            mDialog.window.attributes.gravity = Gravity.CENTER

            val layoutParams = mDialog.window.attributes
            layoutParams.dimAmount = 0.2f

            /** 加载对话框布局 */
            mDialog.window.attributes = layoutParams

            val loadingImageView = mDialog.find<ImageView>(R.id.mProgressIv)
            mDrawable = loadingImageView.drawable as AnimationDrawable

            return mDialog
        }
    }

    /**
     * 显示加载对话框,开始动画集
     */
    fun showLoading() {
        mDialog.show()
        mDrawable.start()
    }

    /**
     * 隐藏加载对话框,停止动画集
     */
    fun hideLoading() {
        mDialog.dismiss()
        mDrawable.stop()
    }
}