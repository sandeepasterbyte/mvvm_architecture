package com.asterbyte.mvvmapp.hilt.di

import com.asterbyte.mvvmapp.data.networkk.MyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

  @Provides
  @Singleton
  fun provideRetrofit(): Retrofit.Builder {
    return Retrofit.Builder()
      .baseUrl("http://restapi.adequateshop.com/api/")
      .addConverterFactory(GsonConverterFactory.create())
  }

  @Provides
  @Singleton
  fun provideMyAPI(retrofit: Retrofit.Builder): MyApi {
    return retrofit.build().create(MyApi::class.java)
  }
}
