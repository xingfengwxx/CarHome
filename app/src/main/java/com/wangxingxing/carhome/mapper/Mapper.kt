package com.wangxingxing.carhome.mapper

/**
 * author : 王星星
 * date : 2021/7/30 17:29
 * email : 1099420259@qq.com
 * description :
 */
interface Mapper<I, O> {
    fun map(input: I): O
}