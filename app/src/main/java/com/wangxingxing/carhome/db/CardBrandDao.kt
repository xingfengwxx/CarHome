package com.wangxingxing.carhome.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wangxingxing.carhome.entity.CarBrandEntity

/**
 * author : 王星星
 * date : 2021/7/30 16:19
 * email : 1099420259@qq.com
 * description :
 */
@Dao
interface CardBrandDao {

    @Query("DELETE FROM CarBrandEntity")
    suspend fun clearCardBrand()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardBrand(carBrandList: List<CarBrandEntity>)

    @Query("SELECT * FROM CarBrandEntity")
    fun getCardBrand(): PagingSource<Int, CarBrandEntity>
}