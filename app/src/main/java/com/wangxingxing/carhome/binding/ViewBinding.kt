package com.wangxingxing.carhome.binding

import android.util.Log
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import coil.load
import com.blankj.utilcode.util.LogUtils
import com.wangxingxing.carhome.R

/**
 * author : 王星星
 * date : 2021/7/30 16:11
 * email : 1099420259@qq.com
 * description :
 */
@BindingAdapter("bindingAvatar")
fun bindingAvatar(imageView: ImageView, url: String?) {
    LogUtils.d("loading image: $url")
    if (url == null) return
    imageView.load(url) {
        crossfade(true) //淡入淡出
        placeholder(R.mipmap.ic_launcher_round) //占位图
    }
}