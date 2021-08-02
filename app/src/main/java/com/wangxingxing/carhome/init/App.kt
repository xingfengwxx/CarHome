package com.wangxingxing.carhome.init

import android.app.Application
import com.blankj.utilcode.util.Utils
import dagger.hilt.android.HiltAndroidApp

/**
 * author : 王星星
 * date : 2021/7/30 15:26
 * email : 1099420259@qq.com
 * description :
 */
@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Utils.init(this)
    }
}