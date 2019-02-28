package com.riningan.mvvmsample.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.data.network.PokeApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PokemonRepositoryImpl(private val mPokeApi: PokeApi) : PokemonRepository {
    override fun getPokemon(): LiveData<List<PokemonResponse>> {
        val mutableLiveData = MutableLiveData<List<PokemonResponse>>()
        mutableLiveData.value = listOf()
        CoroutineScope(Dispatchers.Main).launch {
            mutableLiveData.value = try {
                mPokeApi
                    .getPokemons()
                    .await()
                    .results.map { mPokeApi.getPokemon(it.name).await() }
            } catch (e: java.lang.Exception) {
                listOf()
            }
        }
        return mutableLiveData
    }
}