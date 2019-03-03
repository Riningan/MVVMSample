package com.riningan.mvvmsample.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.riningan.mvvmsample.data.repository.PokemonRepository
import javax.inject.Inject


class ListViewModelFactory @Inject constructor(private val mPokemonRepository: PokemonRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(mPokemonRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}