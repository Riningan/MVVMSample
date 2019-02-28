package com.riningan.mvvmsample.data.repository

import androidx.lifecycle.LiveData
import com.riningan.mvvmsample.data.model.PokemonResponse


interface PokemonRepository {
    fun getPokemon(): LiveData<List<PokemonResponse>>
}