package com.wangxingxing.carhome.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * author : 王星星
 * date : 2021/7/30 16:20
 * email : 1099420259@qq.com
 * description :
 */
@Entity
data class CarBrandEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val page: Int = 0,
    val icon: String
)