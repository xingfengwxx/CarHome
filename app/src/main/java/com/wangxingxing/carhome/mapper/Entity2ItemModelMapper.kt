package com.wangxingxing.carhome.mapper

import com.wangxingxing.carhome.entity.CarBrandEntity
import com.wangxingxing.carhome.model.CarBrandItemModel

/**
 * author : 王星星
 * date : 2021/7/30 19:11
 * email : 1099420259@qq.com
 * description :
 */
class Entity2ItemModelMapper : Mapper<CarBrandEntity, CarBrandItemModel> {
    override fun map(input: CarBrandEntity): CarBrandItemModel =
        CarBrandItemModel(id = input.id, name = input.name, icon = input.icon)

}