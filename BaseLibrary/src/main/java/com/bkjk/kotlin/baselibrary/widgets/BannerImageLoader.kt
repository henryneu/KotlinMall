package com.bkjk.kotlin.baselibrary.widgets

import android.content.Context
import android.widget.ImageView
import com.bkjk.kotlin.baselibrary.utils.GlideUtils
import com.youth.banner.loader.ImageLoader

/**
 * 重写加载图片的 ImageLoader
 */
class BannerImageLoader: ImageLoader() {

    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
        /**
         * 注意：
         * 1.图片加载器由自己选择，这里不限制
         * 2.返回的图片路径为 Object 类型，由于不能确定你到底使用的那种图片加载器，
         * 传输的到的是什么格式，那么这种就使用 Object 接收和返回，你只需要强转成你传输的类型就行，
         * 切记不要胡乱强转！
         */
        GlideUtils.loadImage(context, path.toString(), imageView)
    }
}