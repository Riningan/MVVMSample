package com.riningan.mvvmsample.presentation.pokemon_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.riningan.mvvmsample.data.repository.PokemonRepository
import javax.inject.Inject


class PokemonDetailsViewModelFactory @Inject constructor(private val mPokemonRepository: PokemonRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonDetailsViewModel::class.java)) {
            return PokemonDetailsViewModel(mPokemonRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}