package com.riningan.mvvmsample.presentation.pokemons_list

import androidx.paging.DataSource
import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.data.repository.PokemonRepository


class PokemonsDataSourceFactory(private val mPokemonRepository: PokemonRepository) : DataSource.Factory<Int, PokemonResponse>() {
    override fun create(): DataSource<Int, PokemonResponse> {
        return PokemonsDataSource(mPokemonRepository)
    }
}