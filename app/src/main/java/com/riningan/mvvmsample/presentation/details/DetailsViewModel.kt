package com.riningan.mvvmsample.presentation.details

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.data.repository.PokemonRepository
import com.riningan.mvvmsample.utils.SingleLiveEvent
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class DetailsViewModel(private val mPokemonRepository: PokemonRepository) : ViewModel() {
    private var mJob: Job? = null
    val pokemon = MutableLiveData<PokemonResponse>()
    val backClickListener = ObservableField<View.OnClickListener>()
    val backClick = SingleLiveEvent<Boolean>()


    init {
        backClickListener.set(View.OnClickListener { backClick.value = true })
    }


    override fun onCleared() {
        super.onCleared()
        mJob?.cancel()
    }


    fun start(name: String) {
        mJob = CoroutineScope(Dispatchers.Main).launch {
            pokemon.value = mPokemonRepository.getPokemon(name)
        }
    }


    companion object {
        @JvmStatic
        @BindingAdapter("onNavigationClick")
        fun Toolbar.onNavigationClick(clickListener: View.OnClickListener) {
            setNavigationOnClickListener(clickListener)
        }

        @JvmStatic
        @BindingAdapter("pokemon")
        fun bindPokemon(view: ImageView, pokemon: PokemonResponse?) {
            pokemon?.let {
                Picasso.get().load(it.sprites.front_shiny).into(view)
            }
        }
    }
}