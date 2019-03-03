package com.riningan.mvvmsample.data.repository

import com.riningan.mvvmsample.data.model.PokemonResponse


interface PokemonRepository {
    suspend fun getPokemon(offset: Int, limit: Int): List<PokemonResponse>

    suspend fun getPokemon(name: String): PokemonResponse
}