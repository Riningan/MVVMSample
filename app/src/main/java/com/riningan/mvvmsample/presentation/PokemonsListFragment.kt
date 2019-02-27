package com.riningan.mvvmsample.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.riningan.mvvmsample.databinding.FragmentPokemonsListBinding
import javax.inject.Inject


class PokemonsListFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: PokemonsListViewModelFactory
    lateinit var viewModel: PokemonsListViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPokemonsListBinding>(inflater, com.riningan.mvvmsample.R.layout.fragment_pokemons_list, container, false)
        binding.setLifecycleOwner(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[PokemonsListViewModel::class.java]
        val view = binding.root
        binding.viewModel = viewModel
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel.pokemons.observe(this, Observer {
//
//        })
    }
}