package com.riningan.mvvmsample.data.repository

import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.data.network.PokeApi


class PokemonRepositoryImpl(private val mPokeApi: PokeApi) : PokemonRepository {
    override suspend fun getPokemons(offset: Int, limit: Int): List<PokemonResponse> =
            mPokeApi.getPokemons(offset, limit)
                    .await()
                    .results.map { getPokemon(it.name) }

    override suspend fun getPokemon(name: String): PokemonResponse =
            mPokeApi.getPokemon(name).await()
}