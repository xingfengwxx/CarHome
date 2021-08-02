package com.wangxingxing.carhome.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.wangxingxing.carhome.model.CarBrandItemModel
import com.wangxingxing.carhome.repository.Repository

/**
 * author : 王星星
 * date : 2021/7/30 18:52
 * email : 1099420259@qq.com
 * description :
 */
class MainViewModel @ViewModelInject constructor(
    private val carBrandRepository: Repository
) : ViewModel() {

    val data: LiveData<PagingData<CarBrandItemModel>> = carBrandRepository.fetchCarBrandList()
        .cachedIn(viewModelScope).asLiveData()
}