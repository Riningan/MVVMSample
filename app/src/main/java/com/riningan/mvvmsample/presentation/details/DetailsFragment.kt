package com.riningan.mvvmsample.presentation.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import com.riningan.mvvmsample.R
import com.riningan.mvvmsample.app.App
import com.riningan.mvvmsample.databinding.FragmentDetailsBinding
import javax.inject.Inject


class DetailsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: DetailsViewModelFactory
    @Inject
    lateinit var navController: NavController


    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.getActivityComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentDetailsBinding>(inflater, R.layout.fragment_details, container, false).run {
                setLifecycleOwner(this@DetailsFragment)
                viewModel = ViewModelProviders.of(this@DetailsFragment, viewModelFactory)[DetailsViewModel::class.java].apply {
                    backClick.observe(this@DetailsFragment, Observer {
                        navController.popBackStack()
                    })
                    val args = DetailsFragmentArgs.fromBundle(arguments!!)
                    start(args.pokemonName)
                }
                root
            }
}