package com.wangxingxing.carhome.init

import android.content.Context
import androidx.startup.Initializer

/**
 * author : 王星星
 * date : 2021/7/30 16:03
 * email : 1099420259@qq.com
 * description :
 */
class AppInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        AppHelper.init(context)
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()
}