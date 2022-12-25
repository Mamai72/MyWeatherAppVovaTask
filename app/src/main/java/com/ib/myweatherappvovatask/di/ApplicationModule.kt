package com.ib.myweatherappvovatask.di

import com.google.gson.GsonBuilder
import com.ib.myweatherappvovatask.myretrofit.MyRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    fun provideRetrofit(): MyRetrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.meteomatics.com/")
            .build()
            .create(MyRetrofit::class.java)
    }
}