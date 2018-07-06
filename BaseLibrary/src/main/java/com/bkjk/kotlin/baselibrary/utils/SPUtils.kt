package com.bkjk.kotlin.baselibrary.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.bkjk.kotlin.baselibrary.common.BaseApplication
import com.bkjk.kotlin.baselibrary.common.BaseConstant

/**
 * SharedPreferences 工具类
 * 存储、获取基本数据类型
 */
object SPUtils {

    private var sp: SharedPreferences = BaseApplication.context.getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE)
    private var editor: Editor

    init {
        editor = sp.edit()
    }

    /**
     * 存储 Int 类型数据
     */
    fun putInt(key: String, value: Int) {
        editor.putInt(key, value)
        editor.commit()
    }

    /**
     * 获取 Int 类型数据，默认 0
     */
    fun getInt(key: String): Int {
        return sp.getInt(key, 0)
    }

    /**
     * 存储 String 类型数据
     */
    fun putString(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
    }

    /**
     * 获取 String 类型数据，默认 ""
     */
    fun getString(key: String): String {
        return sp.getString(key, "")
    }

    /**
     * 存储 Boolean 类型数据
     */
    fun putBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.commit()
    }

    /**
     * 获取 Boolean 类型数据，默认 false
     */
    fun getBoolean(key: String): Boolean {
        return sp.getBoolean(key, false)
    }

    /**
     * 存储 Long 类型数据
     */
    fun putLong(key: String, value: Long) {
        editor.putLong(key, value)
        editor.commit()
    }

    /**
     * 获取 Long 类型数据，默认 0
     */
    fun getLong(key: String): Long {
        return sp.getLong(key, 0)
    }

    /**
     * 存储 Set 集合
     */
    fun putSet(key: String, set: Set<String>) {
        // 先获取已存储的 set 集合
        val localSet = getStringSet(key).toMutableSet()
        localSet.addAll(set)
        editor.putStringSet(key, localSet)
        editor.commit()
    }

    /**
     * 获取 Set 集合，默认空 set
     */
    fun getStringSet(key: String): Set<String> {
        val set = setOf<String>()
        return sp.getStringSet(key, set)
    }

    /**
     * 移除 Key
     */
    fun removeKey(key: String) {
        editor.remove(key)
        editor.commit()
    }
}