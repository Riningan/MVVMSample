package com.riningan.mvvmsample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.riningan.mvvmsample.data.PokemonRepository


class PokemonsListViewModelFactory(private val mPokemonRepository: PokemonRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonsListViewModel::class.java)) {
            return PokemonsListViewModel(mPokemonRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}