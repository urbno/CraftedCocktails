package com.bme.aut.craftedcocktails.network

import com.bme.aut.craftedcocktails.network.api.*
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(NetworkConfig.API_ENDPOINT_ADDRESS)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideCreateApi(retrofit: Retrofit): CreateApi = retrofit.create(CreateApi::class.java)

    @Provides
    @Singleton
    fun provideDeleteApi(retrofit: Retrofit): DeleteApi = retrofit.create(DeleteApi::class.java)

    @Provides
    @Singleton
    fun provideFilterApi(retrofit: Retrofit): FilterApi = retrofit.create(FilterApi::class.java)

    @Provides
    @Singleton
    fun provideLookupApi(retrofit: Retrofit): LookupApi = retrofit.create(LookupApi::class.java)

    @Provides
    @Singleton
    fun provideSearchApi(retrofit: Retrofit): SearchApi = retrofit.create(SearchApi::class.java)

    @Provides
    @Singleton
    fun provideUpdateApi(retrofit: Retrofit): UpdateApi = retrofit.create(UpdateApi::class.java)

    @Provides
    @Singleton
    fun provideRandomApi(retrofit: Retrofit): RandomApi = retrofit.create(RandomApi::class.java)
}