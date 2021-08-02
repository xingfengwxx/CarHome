package com.wangxingxing.carhome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.wangxingxing.carhome.databinding.CarbrandItemBinding
import com.wangxingxing.carhome.model.CarBrandItemModel

/**
 * author : 王星星
 * date : 2021/8/2 10:25
 * email : 1099420259@qq.com
 * description :
 */
class CarBrandAdapter(private val context: Context) : PagingDataAdapter<CarBrandItemModel, BindingViewHolder>(object : DiffUtil.ItemCallback<CarBrandItemModel>() {
    override fun areItemsTheSame(oldItem: CarBrandItemModel, newItem: CarBrandItemModel): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: CarBrandItemModel,
        newItem: CarBrandItemModel
    ): Boolean {
        return oldItem == newItem
    }

}) {
    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        getItem(position).let { item ->
            val binding = holder.binding as CarbrandItemBinding
            binding.carBrand = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val binding = CarbrandItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return BindingViewHolder(binding)
    }
}