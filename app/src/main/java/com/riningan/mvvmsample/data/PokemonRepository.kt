package com.riningan.mvvmsample.data

import androidx.lifecycle.LiveData


interface PokemonRepository {
    fun getPokemon(): LiveData<List<PokemonModel>>
}