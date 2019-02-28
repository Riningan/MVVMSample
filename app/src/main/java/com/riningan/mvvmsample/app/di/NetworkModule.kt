package com.riningan.mvvmsample.app.di

import androidx.annotation.NonNull
import com.riningan.mvvmsample.data.network.PokeClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class NetworkModule {
    @Singleton
    @NonNull
    @Provides
    fun apiClient() = PokeClient()

    @Singleton
    @NonNull
    @Provides
    fun api(apiClient: PokeClient) = apiClient.getApi()
}