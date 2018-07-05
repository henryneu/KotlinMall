package com.bkjk.kotlin.baselibrary.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.bkjk.kotlin.baselibrary.R

import kotlinx.android.synthetic.main.layout_header_bar.view.*

class HeaderBar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                          defStyleAttr: Int = 0)
    : FrameLayout(context, attrs, defStyleAttr) {

    /** 是否显示返回图标 */
    private var isShowBack = true
    /** title 文字 */
    private var titleText: String? = null
    /** 右侧文字 */
    private var rightText: String? = null

    init {
        // 获取自定义属性
        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar)
        isShowBack = typeArray.getBoolean(R.styleable.HeaderBar_isShowBack, true)
        titleText = typeArray.getString(R.styleable.HeaderBar_titleText)
        rightText = typeArray.getString(R.styleable.HeaderBar_rightText)

        initView()
        typeArray.recycle()
    }

    /**
     * 初始化视图
     */
    private fun initView() {
        View.inflate(context, R.layout.layout_header_bar, this)

        mHeaderBarIv.visibility = if (isShowBack) View.VISIBLE else View.GONE

        // 标题不为空，设置值
        titleText?.let {
            mHeaderBarTitle.text = it
        }

        // 右侧文字不为空，设置值并可见
        rightText?.let {
            mHeaderBarRt.text = it
            mHeaderBarRt.visibility = View.VISIBLE
        }
    }

    /**
     * 获取左侧视图
     */
    fun getLeftView(): ImageView {
        return mHeaderBarIv
    }

    /**
     * 获取右侧视图
     */
    fun getRightView(): TextView {
        return mHeaderBarRt
    }

    /**
     * 获取右侧文字
     */
    fun getRightText(): String{
        return mHeaderBarRt.text.toString()
    }
}