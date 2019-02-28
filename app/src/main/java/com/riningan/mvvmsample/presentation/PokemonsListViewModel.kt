package com.riningan.mvvmsample.presentation

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.data.repository.PokemonRepository
import javax.inject.Inject


class PokemonsListViewModel @Inject constructor(pokemonRepository: PokemonRepository) : ViewModel() {
    val pokemons: LiveData<PagedList<PokemonResponse>>
    val clickListener = ObservableField<PokemonsAdapter.ItemClickListener>()


    init {
        val pokemonsDataSourceFactory = PokemonsDataSourceFactory(pokemonRepository)
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .build()
        pokemons = LivePagedListBuilder(pokemonsDataSourceFactory, config)
            .build()

        clickListener.set(object : PokemonsAdapter.ItemClickListener {
            override fun onClick(pokemonResponse: PokemonResponse) {
                Log.d(this@PokemonsListViewModel::class.java.simpleName, "pokemonModel = " + pokemonResponse.name)
            }
        })
    }
}