package com.bkjk.kotlin.baselibrary.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView

/**
 * RecyclerView Adapter 基类
 */
abstract class BaseRecyclerViewAdapter<T, viewHolder: RecyclerView.ViewHolder>(var mContext: Context): RecyclerView.Adapter<viewHolder>() {

    /** 数据集合 */
    var mDataList: MutableList<T> = mutableListOf()

    /** item 点击事件监听 */
    var mOnItemClickListener: OnItemClickListener<T>? = null

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            if (mOnItemClickListener != null) {
                mOnItemClickListener!!.onItemClick(mDataList.get(position), position)
            }
        }
    }

    /**
     * 设置 Adapter 的适配数据列表
     */
    fun setList(dataList: MutableList<T>) {
        mDataList = dataList
        notifyDataSetChanged()
    }

    /**
     * RecyclerView item 点击事件监听
     */
    interface OnItemClickListener<in T> {
        fun onItemClick(item: T, position: Int)
    }

    /**
     * 设置 item 事件监听
     */
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<T>) {
        mOnItemClickListener = onItemClickListener
    }
}