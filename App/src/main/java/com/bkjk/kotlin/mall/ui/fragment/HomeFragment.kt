package com.bkjk.kotlin.mall.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bkjk.kotlin.baselibrary.ui.fragment.BaseFragment
import com.bkjk.kotlin.baselibrary.widgets.BannerImageLoader
import com.bkjk.kotlin.mall.R
import com.bkjk.kotlin.mall.common.*
import com.bkjk.kotlin.mall.ui.adapter.GalleryPagerAdapter
import com.bkjk.kotlin.mall.ui.adapter.HomeDiscountAdapter
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.layout_fragment_home.*
import me.crosswall.lib.coverflow.CoverFlow

class HomeFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.layout_fragment_home, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 初始化 Banner
        initBanner()
        // 初始化 ViewFlipper
        initNewsFlipper()
        // 初始化 TriangleLabelView
        initDiscountTlv()
        // 初始化 Gallery
        initGallery()
    }

    /**
     * 初始化 Banner
     */
    private fun initBanner() {

        // 设置图片加载器
        mHomeFragBanner.setImageLoader(BannerImageLoader())
        // 设置 Banner 样式
        // mHomeFragBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
        // 设置图片集合
        mHomeFragBanner.setImages(listOf(HOME_BANNER_ONE, HOME_BANNER_TWO, HOME_BANNER_THREE, HOME_BANNER_FOUR))
        // 设置banner动画效果
        mHomeFragBanner.setBannerAnimation(Transformer.Accordion)
        // 设置自动轮播，默认为true
        // mHomeFragBanner.isAutoPlay(true)
        // 设置轮播时间
        mHomeFragBanner.setDelayTime(2000)
        // 设置指示器位置（当banner模式中有指示器时）
        mHomeFragBanner.setIndicatorGravity(BannerConfig.RIGHT)
        // banner设置方法全部调用完毕时最后调用
        mHomeFragBanner.start()
    }

    /**
     * 初始化 ViewFlipper
     */
    private fun initNewsFlipper() {
        mNewsFlipperView.setData(arrayOf("夏日炎炎，聚划算夏季大牌特惠抢多件更划算", "新用户立领1000元优惠券，满8000减1000大牌12期免息无忧", "抢199减100券，另直播送好礼两件半价"))
    }

    /**
     * 初始化 TriangleLabelView
     */
    private fun initDiscountTlv() {
        val manager = LinearLayoutManager(context)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        mHomeDiscountRv.layoutManager = manager

        val discountAdapter = HomeDiscountAdapter(activity)
        mHomeDiscountRv.adapter = discountAdapter
        discountAdapter.setList(mutableListOf(HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR, HOME_DISCOUNT_FIVE))
    }

    /**
     * 初始化 Gallery
     */
    private fun initGallery() {
        mGalleryVp.adapter = GalleryPagerAdapter(context, listOf(HOME_TOPIC_ONE, HOME_TOPIC_TWO, HOME_TOPIC_THREE, HOME_TOPIC_FOUR, HOME_TOPIC_FIVE))
        mGalleryVp.currentItem = 1
        mGalleryVp.offscreenPageLimit = 5

        CoverFlow.Builder()
                .with(mGalleryVp)
                .scale(0.3f)
                .pagerMargin(-30.0f)
                .spaceSize(0.0f)
                .build()
    }
}