package com.wangxingxing.carhome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.wangxingxing.carhome.databinding.NetworkStateItemBinding

/**
 * author : 王星星
 * date : 2021/8/2 11:06
 * email : 1099420259@qq.com
 * description :
 */
class FooterAdapter(val adapter: CarBrandAdapter, val context: Context) :
    LoadStateAdapter<NetworkStateItemViewHolder>() {
    override fun onBindViewHolder(holder: NetworkStateItemViewHolder, loadState: LoadState) {
        //水平居中
        val params = holder.itemView.layoutParams
        if (params is StaggeredGridLayoutManager.LayoutParams) {
            params.isFullSpan = true
        }
        holder.bindData(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): NetworkStateItemViewHolder {
        val binding = NetworkStateItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return NetworkStateItemViewHolder(binding) {
            adapter.retry()
        }
    }

}