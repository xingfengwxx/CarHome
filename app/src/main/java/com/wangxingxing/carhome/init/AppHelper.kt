package com.wangxingxing.carhome.init

import android.content.Context

/**
 * author : 王星星
 * date : 2021/7/30 15:35
 * email : 1099420259@qq.com
 * description :
 */

const val BASE_URL = "http://121.4.214.140:8080/paging-server/"

object AppHelper {
    lateinit var mContext: Context

    fun init(context: Context) {
        mContext = context
    }
}