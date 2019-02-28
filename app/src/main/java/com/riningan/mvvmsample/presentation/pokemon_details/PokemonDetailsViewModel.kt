package com.riningan.mvvmsample.presentation.pokemon_details

import androidx.lifecycle.ViewModel
import com.riningan.mvvmsample.data.repository.PokemonRepository
import javax.inject.Inject


class PokemonDetailsViewModel @Inject constructor(pokemonRepository: PokemonRepository) : ViewModel() {
//    val pokemons: LiveData<PagedList<PokemonResponse>>
//    val clickListener = ObservableField<PokemonsAdapter.ItemClickListener>()


    init {
//        val pokemonsDataSourceFactory = PokemonsDataSourceFactory(pokemonRepository)
//        val config = PagedList.Config.Builder()
//            .setEnablePlaceholders(false)
//            .setInitialLoadSizeHint(10)
//            .setPageSize(10)
//            .build()
//        pokemons = LivePagedListBuilder(pokemonsDataSourceFactory, config)
//            .build()
//
//        clickListener.set(object : PokemonsAdapter.ItemClickListener {
//            override fun onClick(pokemonResponse: PokemonResponse) {
//                Log.d(this@PokemonDetailsViewModel::class.java.simpleName, "pokemonModel = " + pokemonResponse.name)
//            }
//        })
    }
}