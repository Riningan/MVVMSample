package com.riningan.mvvmsample.presentation.pokemon_details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.riningan.mvvmsample.app.App
import com.riningan.mvvmsample.databinding.FragmentPokemonDetailsBinding
import javax.inject.Inject


class PokemonDetailsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: PokemonDetailsViewModelFactory


    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.getAppComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding =
            DataBindingUtil.inflate<FragmentPokemonDetailsBinding>(inflater, com.riningan.mvvmsample.R.layout.fragment_pokemon_details, container, false)
        binding.setLifecycleOwner(this)
        binding.viewModel = ViewModelProviders.of(this, viewModelFactory)[PokemonDetailsViewModel::class.java]
        return binding.root
    }
}