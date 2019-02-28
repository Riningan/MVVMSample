package com.riningan.mvvmsample.data.repository

import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.data.network.PokeApi


class PokemonRepositoryImpl(private val mPokeApi: PokeApi) : PokemonRepository {
    override suspend fun getPokemon(offset: Int, limit: Int): List<PokemonResponse> = try {
        mPokeApi
            .getPokemons(offset, limit)
            .await()
            .results.map { mPokeApi.getPokemon(it.name).await() }
    } catch (e: Exception) {
        listOf()
    }
}