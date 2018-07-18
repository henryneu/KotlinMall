package com.bkjk.kotlin.mall.ui.adapter

import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bkjk.kotlin.baselibrary.ui.adapter.BaseRecyclerViewAdapter
import com.bkjk.kotlin.baselibrary.utils.GlideUtils
import com.bkjk.kotlin.mall.R
import kotlinx.android.synthetic.main.layout_home_discount_item.view.*

class HomeDiscountAdapter(context: Context): BaseRecyclerViewAdapter<String, HomeDiscountAdapter.ViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_discount_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        // 加载商品图片
        GlideUtils.loadImage(mContext, mDataList[position], holder.itemView.mDiscountGoodIm)
        holder.itemView.mDiscountBeforeTv.text = "￥1000.00"
        holder.itemView.mDiscountAfterTv.text = "￥500.00"
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        init {
            // 设置TextView样式
            view.mDiscountBeforeTv.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
            view.mDiscountBeforeTv.paint.isAntiAlias = true
        }
    }
}