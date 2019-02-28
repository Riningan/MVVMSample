package com.riningan.mvvmsample.presentation.pokemons_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.riningan.mvvmsample.data.repository.PokemonRepository
import javax.inject.Inject


class PokemonsListViewModelFactory @Inject constructor(private val mPokemonRepository: PokemonRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonsListViewModel::class.java)) {
            return PokemonsListViewModel(mPokemonRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}