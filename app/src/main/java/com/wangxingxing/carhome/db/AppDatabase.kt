package com.wangxingxing.carhome.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wangxingxing.carhome.entity.CarBrandEntity

/**
 * author : 王星星
 * date : 2021/7/30 16:18
 * email : 1099420259@qq.com
 * description :
 */
@Database(
    entities = [CarBrandEntity::class],
    version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun carBrandDao(): CardBrandDao
}