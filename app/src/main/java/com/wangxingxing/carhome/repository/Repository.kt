package com.wangxingxing.carhome.repository

import androidx.paging.PagingData
import com.wangxingxing.carhome.model.CarBrandItemModel
import kotlinx.coroutines.flow.Flow

/**
 * author : 王星星
 * date : 2021/7/30 17:24
 * email : 1099420259@qq.com
 * description :
 */
interface Repository {

    fun fetchCarBrandList() : Flow<PagingData<CarBrandItemModel>>
}