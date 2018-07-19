package com.bkjk.kotlin.mall.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bkjk.kotlin.baselibrary.ext.onClick
import com.bkjk.kotlin.baselibrary.ui.fragment.BaseFragment
import com.bkjk.kotlin.mall.R
import kotlinx.android.synthetic.main.layout_fragment_mine.*

class MineFragment: BaseFragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.layout_fragment_mine, null)

        initView()
    }

    private fun initView() {
        mSettingTv.onClick(this)
    }

    override fun onClick(view: View?) {
    }
}