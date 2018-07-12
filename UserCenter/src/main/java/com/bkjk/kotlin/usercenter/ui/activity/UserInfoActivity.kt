package com.bkjk.kotlin.usercenter.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.bkjk.kotlin.baselibrary.ext.onClick
import com.bkjk.kotlin.baselibrary.ui.activity.BaseMVPActivity
import com.bkjk.kotlin.baselibrary.utils.DateUtils
import com.bkjk.kotlin.usercenter.R
import com.bkjk.kotlin.usercenter.injection.component.DaggerUserComponent
import com.bkjk.kotlin.usercenter.injection.module.UserModule
import com.bkjk.kotlin.usercenter.presenter.UserInfoPresenter
import com.bkjk.kotlin.usercenter.presenter.view.UserInfoView
import com.jph.takephoto.app.TakePhoto
import com.jph.takephoto.app.TakePhotoImpl
import com.jph.takephoto.compress.CompressConfig
import com.jph.takephoto.model.InvokeParam
import com.jph.takephoto.model.TContextWrap
import com.jph.takephoto.model.TResult
import com.jph.takephoto.permission.InvokeListener
import com.jph.takephoto.permission.PermissionManager
import kotlinx.android.synthetic.main.activity_user_info.*
import java.io.File

/**
 * 用户信息界面
 */
class UserInfoActivity: BaseMVPActivity<UserInfoPresenter>(), UserInfoView, View.OnClickListener,
        TakePhoto.TakeResultListener {

    private lateinit var mTakePhoto: TakePhoto
    private lateinit var mTempFile: File
    // private lateinit var invokeParam: InvokeParam

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        mTakePhoto = TakePhotoImpl(this, this)
        mTakePhoto.onCreate(savedInstanceState)

        /** 初始化布局 */
        initView()
    }

    /**
     * 初始化布局
     */
    private fun initView() {
        mHeaderBar.getRightView().visibility = View.VISIBLE
        mUserIconIv.onClick {
            showAlertView()
        }
    }

    /**
     * 选择图片来源弹窗
     */
    private fun showAlertView() {
        AlertView("选择图片", null, "取消", null, arrayOf("拍照", "相册"),
                this, AlertView.Style.ActionSheet, object : OnItemClickListener {
            override fun onItemClick(o: Any?, position: Int) {
                mTakePhoto.onEnableCompress(CompressConfig.ofDefaultConfig(), false)
                when(position) {
                    0 -> {
                        createTempFile()
                        mTakePhoto.onPickFromCapture(Uri.fromFile(mTempFile))
                    }
                    1 -> mTakePhoto.onPickFromGallery()
                }
            }
        }).show()
    }

    /**
     * 创建存储图片的文件
     */
    private fun createTempFile() {
        val tempFileName = "${DateUtils.curTime}.png"
        if (Environment.MEDIA_MOUNTED.equals(Environment.isExternalStorageEmulated())) {
            this.mTempFile = File(Environment.getExternalStorageDirectory(), tempFileName)
            return
        }
        this.mTempFile = File(filesDir, tempFileName)
    }

    /**
     * 初始化依赖注入
     */
    override fun initInjectionComponent() {
        DaggerUserComponent.builder()
                .activityComponent(activityComponent)
                .userModule(UserModule())
                .build().inject(this)
        mPresenter.mView = this
    }

    /**
     * 处理点击事件
     */
    override fun onClick(view: View) {
        when(view.id) {

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mTakePhoto.onActivityResult(requestCode, resultCode, data)
    }

    override fun takeSuccess(result: TResult?) {

    }

    override fun takeCancel() {

    }

    override fun takeFail(result: TResult?, msg: String?) {

    }

//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        var type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        PermissionManager.handlePermissionsResult(this, type, invokeParam, this)
//    }
//
//    override fun invoke(invokeParam: InvokeParam): PermissionManager.TPermissionType {
//        var type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam.getMethod())
//        if(PermissionManager.TPermissionType.WAIT.equals(type)){
//            this.invokeParam = invokeParam
//        }
//        return type
//    }
}