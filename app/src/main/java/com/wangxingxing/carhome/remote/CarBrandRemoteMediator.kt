package com.wangxingxing.carhome.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.blankj.utilcode.util.LogUtils
import com.wangxingxing.carhome.db.AppDatabase
import com.wangxingxing.carhome.entity.CarBrandEntity
import com.wangxingxing.carhome.ext.isConnectedNetwork
import com.wangxingxing.carhome.init.AppHelper
import com.wangxingxing.carhome.init.BASE_URL

/**
 * author : 王星星
 * date : 2021/7/30 17:37
 * email : 1099420259@qq.com
 * description :
 */
@OptIn(ExperimentalPagingApi::class)
class CarBrandRemoteMediator(
    private val api: CarBrandService,
    private val database: AppDatabase
) : RemoteMediator<Int, CarBrandEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CarBrandEntity>
    ): MediatorResult {
        try {
            LogUtils.d("loadType: $loadType")
            //第一步，判断 LoadType
            val pageKey = when (loadType) {
                //首次访问 或者调用 PagingDataAdapter.refresh()
                LoadType.REFRESH -> null
                //在当前列表头部添加数据的时候使用
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                //下来加载更多时触发
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull() ?: return MediatorResult.Success(
                        endOfPaginationReached = true
                    )
                    lastItem.page
                }
            }

            // 无网络，加载本地数据
            if (!AppHelper.mContext.isConnectedNetwork()) {
                return MediatorResult.Success(endOfPaginationReached = true)
            }

            //第二步，请求网络分页数据
            val page = pageKey ?: 0
            val result = api.fetchCarBrandList(
                page * state.config.pageSize,
                state.config.pageSize
            )

            val endOfPaginationReached = result.isEmpty()
            val item = result.map {
                CarBrandEntity(
                    id = it.id,
                    name = it.name,
                    icon = "${BASE_URL + "images/" + it.icon}",
                    page = page + 1
                )
            }

            //第三步，插入数据库。
            val carBrandDao = database.carBrandDao()
            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    //下拉刷新或者首次加载，清空
                    carBrandDao.clearCardBrand()
                }
                carBrandDao.insertCardBrand(item)
            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            e.printStackTrace()
            return MediatorResult.Error(e)
        }

    }
}