package com.riningan.mvvmsample.data.network

import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.data.model.PokemonsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokeApi {
    @GET("pokemon")
    fun getPokemons(@Query("offset") offset: Int = 0, @Query("limit") limit: Int = 20): Deferred<PokemonsResponse>

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") name: String): Deferred<PokemonResponse>
}