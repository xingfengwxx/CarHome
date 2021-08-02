package com.wangxingxing.carhome.remote

import com.wangxingxing.carhome.model.CarBrandItemModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * author : 王星星
 * date : 2021/7/30 16:52
 * email : 1099420259@qq.com
 * description :
 */
interface CarBrandService {

    @GET("carBrand.do")
    suspend fun fetchCarBrandList(
        @Query("since") since: Int,
        @Query("pagesize") pageSize: Int,
    ): List<CarBrandItemModel>
}