package com.riningan.mvvmsample

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.riningan.mvvmsample.data.network.PokeApi
import com.riningan.mvvmsample.data.repository.PokemonRepositoryImpl
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class PokemonRepositoryImplTest {
    private lateinit var mMockPokeApi: PokeApi
    private lateinit var mPokemonRepositoryImpl: PokemonRepositoryImpl


    @Before
    fun setup() {
        mMockPokeApi = mock {
            on { getPokemons(0, 2) } doReturn CompletableDeferred(pokemonsResponse1)
            on { getPokemons(2, 2) } doReturn CompletableDeferred(pokemonsResponse2)
            on { getPokemon(pokemonResponse1.name) } doReturn CompletableDeferred(pokemonResponse1)
            on { getPokemon(pokemonResponse2.name) } doReturn CompletableDeferred(pokemonResponse2)
            on { getPokemon(pokemonResponse3.name) } doReturn CompletableDeferred(pokemonResponse3)
            on { getPokemon(pokemonResponse4.name) } doReturn CompletableDeferred(pokemonResponse4)
        }
        mPokemonRepositoryImpl = PokemonRepositoryImpl(mMockPokeApi)
    }


    @Test
    fun getPokemons() {
        runBlocking {
            var pokemons = mPokemonRepositoryImpl.getPokemons(0, 2)
            assertEquals(pokemons.size, 2)
            assertEquals(pokemons[0], pokemonResponse1)
            assertEquals(pokemons[1], pokemonResponse2)

            pokemons = mPokemonRepositoryImpl.getPokemons(2, 2)
            assertEquals(pokemons.size, 2)
            assertEquals(pokemons[0], pokemonResponse3)
            assertEquals(pokemons[1], pokemonResponse4)
        }
    }

    @Test
    fun getPokemon() {
        runBlocking {
            val pokemon = mPokemonRepositoryImpl.getPokemon(pokemonResponse1.name)
            assertEquals(pokemon, pokemonResponse1)
        }
    }
}
