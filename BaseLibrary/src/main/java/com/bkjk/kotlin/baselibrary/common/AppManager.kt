package com.bkjk.kotlin.baselibrary.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * 单例模式
 * 管理 Activity
 */
class AppManager private constructor() {

    /** AppManager 实例 */
    companion object {
        val instances: AppManager by lazy { AppManager() }
    }

    /** 存储 Activity 实例的栈 */
    private val activityStack: Stack<Activity> = Stack<Activity>()

    /**
     * Activity 入栈
     */
    fun inputActivityStack(activity: Activity) {
        activityStack.push(activity)
    }

    /**
     * Activity 出栈
     */
    fun removeActivityStack(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    /**
     * 获取栈顶 Activity
     */
    fun currentActivity(): Activity {
        return activityStack.lastElement()
    }

    /**
     * 移除栈内所有 Activity
     */
    fun removeAllActivity() {
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }

    /**
     * 退出当前应用程序
     */
    fun exitApp(context: Context) {
        removeAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }
}