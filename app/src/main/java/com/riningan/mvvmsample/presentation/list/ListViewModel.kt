package com.riningan.mvvmsample.presentation.list

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.data.repository.PokemonRepository
import com.riningan.mvvmsample.utils.SingleLiveEvent


class ListViewModel(pokemonRepository: PokemonRepository) : ViewModel() {
    val pokemons: LiveData<PagedList<PokemonResponse>>
    val clickListener = ObservableField<PokemonsAdapter.ItemClickListener>()
    val listItemClick = SingleLiveEvent<PokemonResponse>()


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
                listItemClick.value = pokemonResponse
            }
        })
    }


    companion object {
        @JvmStatic
        @BindingAdapter("listener")
        fun RecyclerView.bindListener(clickListener: PokemonsAdapter.ItemClickListener) {
            adapter = PokemonsAdapter(clickListener, PokemonsDiffUtilCallback())
        }

        @JvmStatic
        @BindingAdapter("pokemons")
        fun RecyclerView.bindPokemons(pokemons: PagedList<PokemonResponse>?) {
            (adapter as PokemonsAdapter).submitList(pokemons)
        }
    }
}