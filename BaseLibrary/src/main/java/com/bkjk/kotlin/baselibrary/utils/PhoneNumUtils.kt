package com.bkjk.kotlin.baselibrary.utils

import java.util.regex.Pattern

/**
 * 手机号码工具类
 */
object PhoneNumUtils {

    /***
     * 手机号码正则检测
     * <p>移动：134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188、198</p>
     * <p>联通：130、131、132、145、155、156、175、176、185、186、166</p>
     * <p>电信：133、153、173、177、180、181、189、199</p>
     * <p>全球星：1349</p>
     * <p>虚拟运营商：170</p>
     *
     * @param  手机号码
     *
     * @return 是否匹配
     */
    fun checkPhoneNum(num: String): Boolean {
        val regExp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$"
        val p = Pattern.compile(regExp)
        val m = p.matcher(num)
        return m.matches()
    }
}