package com.riningan.mvvmsample.app.di

import com.riningan.mvvmsample.presentation.pokemon_details.PokemonDetailsFragment
import com.riningan.mvvmsample.presentation.pokemons_list.PokemonsListFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, DataModule::class])
interface AppComponent {
    fun inject(pokemonsListFragment: PokemonsListFragment)
    fun inject(pokemonDetailsFragment: PokemonDetailsFragment)
}