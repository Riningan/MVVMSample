package com.riningan.mvvmsample.presentation.list

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
import com.riningan.mvvmsample.databinding.FragmentListBinding
import javax.inject.Inject


class ListFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ListViewModelFactory
    @Inject
    lateinit var navController: NavController


    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.getActivityComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentListBinding>(inflater, R.layout.fragment_list, container, false).run {
                setLifecycleOwner(this@ListFragment)
                viewModel = ViewModelProviders.of(this@ListFragment, viewModelFactory)[ListViewModel::class.java].apply {
                    listItemClick.observe(this@ListFragment, Observer {
                        val action = ListFragmentDirections.actionToDetails(it.name)
                        navController.navigate(action)
                    })
                }
                root
            }
}