package com.zobaze.zobazerefractortask.bevarages.di

import com.zobaze.zobazerefractortask.bevarages.data.network.RetrofitApi
import com.zobaze.zobazerefractortask.bevarages.domain.Repository
import com.zobaze.zobazerefractortask.bevarages.data.RepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun provideRetrofit()=Retrofit.Builder()
        .baseUrl("https://api.sampleapis.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(RetrofitApi::class.java)

    @Provides
    fun provideRepository(api: RetrofitApi): Repository = RepositoryImp(api)

}