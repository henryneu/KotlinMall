package com.bkjk.kotlin.messagecenter.widgets

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.ViewFlipper
import com.bkjk.kotlin.messagecenter.R
import org.jetbrains.anko.dimen
import org.jetbrains.anko.px2sp
import org.jetbrains.anko.singleLine

/**
 * 封装公告组件
 */
class NewsFlipperView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        FrameLayout(context, attrs, defStyleAttr) {

    private val mNewsFlipper: ViewFlipper

    init {
        val rootView = View.inflate(context, R.layout.layout_news_flipper, null)
        mNewsFlipper = rootView.findViewById(R.id.mNewsFlipper)
        mNewsFlipper.setInAnimation(context, R.anim.news_bottom_in_anim)
        mNewsFlipper.setOutAnimation(context, R.anim.news_bottom_out_anim)
        addView(rootView)
    }

    /**
     * 构建公告
     */
    private fun buildNewsView(text: String): View {
        val textView = TextView(context)
        textView.text = text
        textView.textSize = px2sp(dimen(R.dimen.text_middle_size))
        textView.singleLine = true
        textView.ellipsize = TextUtils.TruncateAt.END
        textView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        return textView
    }

    /**
     * 设置公告数据
     */
    fun setData(data: Array<String>) {
        for (text in data) {
            mNewsFlipper.addView(buildNewsView(text))
        }
        mNewsFlipper.startFlipping()
    }
}