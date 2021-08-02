package com.wangxingxing.carhome.di

import com.wangxingxing.carhome.db.AppDatabase
import com.wangxingxing.carhome.mapper.Entity2ItemModelMapper
import com.wangxingxing.carhome.remote.CarBrandService
import com.wangxingxing.carhome.repository.CarBrandRepositoryImpl
import com.wangxingxing.carhome.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * author : 王星星
 * date : 2021/7/30 17:22
 * email : 1099420259@qq.com
 * description :
 */
@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCarBrandRepository(
        api: CarBrandService,
        database: AppDatabase
    ): Repository {
        return CarBrandRepositoryImpl(api, database, Entity2ItemModelMapper())
    }
}