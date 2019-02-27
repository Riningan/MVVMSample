package com.riningan.mvvmsample.presentation

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.riningan.mvvmsample.data.PokemonModel
import com.riningan.mvvmsample.data.PokemonRepository
import javax.inject.Inject


class PokemonsListViewModel @Inject constructor(private val mPokemonRepository: PokemonRepository) : ViewModel() {
    val pokemons: LiveData<List<PokemonModel>>
    val clickListener = ObservableField<PokemonsAdapter.ItemClickListener>()

    init {
        pokemons = Tra
    }
}