package com.riningan.mvvmsample.presentation

import androidx.paging.PositionalDataSource
import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.data.repository.PokemonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PokemonsDataSource(private val mPokemonRepository: PokemonRepository) : PositionalDataSource<PokemonResponse>() {
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<PokemonResponse>) {
        CoroutineScope(Dispatchers.Main).launch {
            val result = mPokemonRepository.getPokemon(0, 10)
            callback.onResult(result, 0)
        }
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<PokemonResponse>) {
        CoroutineScope(Dispatchers.Main).launch {
            val result = mPokemonRepository.getPokemon(params.startPosition, params.loadSize)
            callback.onResult(result)
        }
    }
}