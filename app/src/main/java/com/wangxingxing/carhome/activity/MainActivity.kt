package com.wangxingxing.carhome.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.wangxingxing.carhome.adapter.CarBrandAdapter
import com.wangxingxing.carhome.adapter.FooterAdapter
import com.wangxingxing.carhome.databinding.ActivityMainBinding
import com.wangxingxing.carhome.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

/**
 * author : 王星星
 * date : 2021/7/30 15:26
 * email : 1099420259@qq.com
 * description : 
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val mCarBrandAdapter by lazy { CarBrandAdapter(this) }
    private val mViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        mBinding.recyclerView.adapter = mCarBrandAdapter.withLoadStateFooter(FooterAdapter(mCarBrandAdapter, this))
        mViewModel.data.observe(this, {
            mCarBrandAdapter.submitData(lifecycle, it)
            mBinding.swiperRefresh.isEnabled = false
        })

        lifecycleScope.launchWhenCreated {
            mCarBrandAdapter.loadStateFlow.collectLatest { state ->
                mBinding.swiperRefresh.isRefreshing = state.refresh is LoadState.Loading
            }
        }
    }
}