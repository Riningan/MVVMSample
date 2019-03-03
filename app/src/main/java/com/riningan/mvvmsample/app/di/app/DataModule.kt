package com.riningan.mvvmsample.app.di.app

import androidx.annotation.NonNull
import com.riningan.mvvmsample.data.network.PokeApi
import com.riningan.mvvmsample.data.repository.PokemonRepository
import com.riningan.mvvmsample.data.repository.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataModule {
    @Singleton
    @NonNull
    @Provides
    fun repository(pokeApi: PokeApi): PokemonRepository = PokemonRepositoryImpl(pokeApi)
}