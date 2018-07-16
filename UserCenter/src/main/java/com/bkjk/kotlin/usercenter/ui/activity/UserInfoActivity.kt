package com.bkjk.kotlin.usercenter.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.bkjk.kotlin.baselibrary.common.BaseConstant
import com.bkjk.kotlin.baselibrary.ext.onClick
import com.bkjk.kotlin.baselibrary.ui.activity.BaseMVPActivity
import com.bkjk.kotlin.baselibrary.utils.DateUtils
import com.bkjk.kotlin.baselibrary.utils.GlideUtils
import com.bkjk.kotlin.baselibrary.utils.SPUtils
import com.bkjk.kotlin.provider.common.ProviderConstant
import com.bkjk.kotlin.usercenter.R
import com.bkjk.kotlin.usercenter.date.protocol.UserInfo
import com.bkjk.kotlin.usercenter.injection.component.DaggerUserComponent
import com.bkjk.kotlin.usercenter.injection.module.UserModule
import com.bkjk.kotlin.usercenter.presenter.UserInfoPresenter
import com.bkjk.kotlin.usercenter.presenter.view.UserInfoView
import com.bkjk.kotlin.usercenter.utils.UserPrefsUtils
import com.jph.takephoto.app.TakePhoto
import com.jph.takephoto.app.TakePhotoImpl
import com.jph.takephoto.compress.CompressConfig
import com.jph.takephoto.model.TResult
import com.qiniu.android.http.ResponseInfo
import com.qiniu.android.storage.UpCompletionHandler
import com.qiniu.android.storage.UploadManager
import kotlinx.android.synthetic.main.activity_user_info.*
import org.jetbrains.anko.toast
import org.json.JSONObject
import java.io.File

/**
 * 用户信息界面
 */
class UserInfoActivity: BaseMVPActivity<UserInfoPresenter>(), UserInfoView,
        TakePhoto.TakeResultListener {

    private lateinit var mTakePhoto: TakePhoto
    private lateinit var mTempFile: File
    // private lateinit var invokeParam: InvokeParam
    private var mLocalFileUrl: String? = null
    private var mRemoteFileUrl: String? = null

    private var mUserIcon: String? = null
    private var mUserName: String? = null
    private var mUserMobile: String? = null
    private var mUserGender: String? = null
    private var mUserSignature: String? = null

    private val mUploadManager by lazy { UploadManager() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        mTakePhoto = TakePhotoImpl(this, this)
        mTakePhoto.onCreate(savedInstanceState)

        /** 初始化布局 */
        initView()
        /** 初始化数据 */
        initData()
    }

    /**
     * 初始化布局
     */
    private fun initView() {
        mHeaderBar.getRightView().visibility = View.VISIBLE
        mHeaderBar.getRightView().onClick {
            mPresenter.editUser(mRemoteFileUrl!!, mNickNameEt.text?.toString()?: "",
                    if (mGenderMaleRb.isChecked) "0" else "1",
                    mInputSignatureEt.text?.toString()?: "")
        }
        mUserIconIv.onClick {
            showAlertView()
        }
    }

    /**
     * 初始化数据
     */
    private fun initData() {
        mUserIcon = SPUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
        mUserName = SPUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
        mUserMobile = SPUtils.getString(ProviderConstant.KEY_SP_USER_MOBILE)
        mUserGender = SPUtils.getString(ProviderConstant.KEY_SP_USER_GENDER)
        mUserSignature = SPUtils.getString(ProviderConstant.KEY_SP_USER_SIGNATURE)

        mRemoteFileUrl = mUserIcon
        if (mUserIcon != "") {
            GlideUtils.loadImage(this@UserInfoActivity, mUserIcon!!, mUserIconIv)
        }
        mNickNameEt.setText(mUserName)
        mUserMobileTv.text = mUserMobile

        if (mUserGender == "0") {
            mGenderMaleRb.isChecked = true
        }
        else {
            mGenderFemaleRb.isChecked = true
        }

        mInputSignatureEt.setText(mUserSignature)
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
     * 获取上传所需 Token 凭证
     */
    override fun onGetUploadTokenResult(result: String) {
        mUploadManager.put(mLocalFileUrl, null, result, object : UpCompletionHandler{
            override fun complete(key: String?, info: ResponseInfo?, response: JSONObject?) {
                mRemoteFileUrl = BaseConstant.IMAGE_SERVER_ADDRESS + response?.get("hash")
                GlideUtils.loadImage(this@UserInfoActivity, mRemoteFileUrl!!, mUserIconIv)
            }
        }, null)
    }

    /**
     * 编辑用户资料回调
     */
    override fun onEditUserResult(result: UserInfo) {
        toast("修改成功")
        // 更新已存储的用户信息
        UserPrefsUtils.putUserInfo(result)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mTakePhoto.onActivityResult(requestCode, resultCode, data)
    }

    override fun takeSuccess(result: TResult?) {
        mLocalFileUrl = result?.image?.compressPath
        mPresenter.getUploadToken()
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