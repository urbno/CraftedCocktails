package com.bme.aut.craftedcocktails.mock

import com.bme.aut.craftedcocktails.network.api.*
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class MockNetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Singleton
    fun provideCreateApi(): CreateApi = MockCreateApi()

    @Provides
    @Singleton
    fun provideDeleteApi(): DeleteApi = MockDeleteApi()

    @Provides
    @Singleton
    fun provideFilterApi(): FilterApi = MockFilterApi()

    @Provides
    @Singleton
    fun provideLookupApi(): LookupApi = MockLookupApi()

    @Provides
    @Singleton
    fun provideSearchApi(): SearchApi = MockSearchApi()

    @Provides
    @Singleton
    fun provideUpdateApi(): UpdateApi = MockUpdateApi()

    @Provides
    @Singleton
    fun provideRandomApi(): RandomApi = MockRandomApi()
}