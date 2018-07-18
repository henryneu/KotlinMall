package com.bkjk.kotlin.mall.ui.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bkjk.kotlin.baselibrary.ext.loadUrl
import com.bkjk.kotlin.mall.R
import kotlinx.android.synthetic.main.layout_gallery_pager_item.view.*

/**
 * 画廊图片适配器
 */
class GalleryPagerAdapter(private val context: Context, private val list: List<String>): PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val rootView = LayoutInflater.from(this.context).inflate(R.layout.layout_gallery_pager_item, null)
        rootView.mGalleryPagerIv.loadUrl(list[position])
        container.addView(rootView)
        return rootView
    }

    override fun isViewFromObject(view: View, paramObject: Any): Boolean {
        return view == paramObject
    }

    override fun getCount(): Int {
        return this.list.size
    }

    override fun destroyItem(container: ViewGroup, paramInt: Int, paramObject: Any) {
        container.removeView(paramObject as View)
    }
}