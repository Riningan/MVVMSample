package com.riningan.mvvmsample.app.di

import com.riningan.mvvmsample.presentation.PokemonsListFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, DataModule::class])
interface AppComponent {
    fun inject(pokemonsListFragment: PokemonsListFragment)
}