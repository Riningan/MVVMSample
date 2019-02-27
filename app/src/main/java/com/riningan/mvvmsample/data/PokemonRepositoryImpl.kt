package com.riningan.mvvmsample.data

import androidx.lifecycle.LiveData


class PokemonRepositoryImpl : PokemonRepository {
    override fun getPokemon(): LiveData<List<PokemonModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    //https://pokeapi.co/api/v2/pokemon?offset=0&limit=50
}