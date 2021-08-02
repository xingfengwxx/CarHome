package com.wangxingxing.carhome.di

import android.util.Log
import com.wangxingxing.carhome.init.BASE_URL
import com.wangxingxing.carhome.remote.CarBrandService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * author : 王星星
 * date : 2021/7/30 16:45
 * email : 1099420259@qq.com
 * description :
 */
@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    private val TAG = "NetworkModule"

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Log.w(TAG, it)
        })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideCarBrandService(retrofit: Retrofit): CarBrandService {
        return retrofit.create(CarBrandService::class.java)
    }
}