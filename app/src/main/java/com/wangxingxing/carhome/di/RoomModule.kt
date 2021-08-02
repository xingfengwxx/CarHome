package com.wangxingxing.carhome.di

import android.app.Application
import androidx.room.Room
import com.wangxingxing.carhome.db.AppDatabase
import com.wangxingxing.carhome.db.CardBrandDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * author : 王星星
 * date : 2021/7/30 19:01
 * email : 1099420259@qq.com
 * description :
 */
@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "car_home.db")
            .build()
    }

    @Singleton
    @Provides
    fun provideCarBrandDao(database: AppDatabase): CardBrandDao {
        return database.carBrandDao()
    }
}