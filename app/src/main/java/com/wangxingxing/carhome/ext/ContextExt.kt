package com.wangxingxing.carhome.ext

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * author : 王星星
 * date : 2021/7/30 16:27
 * email : 1099420259@qq.com
 * description :
 */
@Suppress("DEPRECATION")
@SuppressLint("MissingPermission")
fun Context.isConnectedNetwork(): Boolean = run {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    activeNetwork?.isConnectedOrConnecting == true
}