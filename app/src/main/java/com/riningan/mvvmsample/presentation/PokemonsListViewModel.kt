package com.riningan.mvvmsample.presentation

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.data.repository.PokemonRepository
import javax.inject.Inject


class PokemonsListViewModel @Inject constructor(pokemonRepository: PokemonRepository) : ViewModel() {
    val pokemons: LiveData<List<PokemonResponse>> = pokemonRepository.getPokemon()
    val clickListener = ObservableField<PokemonsAdapter.ItemClickListener>()

    init {
        clickListener.set(object : PokemonsAdapter.ItemClickListener {
            override fun onClick(pokemonModel: PokemonResponse) {
                Log.d(this@PokemonsListViewModel::class.java.simpleName, "pokemonModel = " + pokemonModel.name)
            }
        })
    }
}