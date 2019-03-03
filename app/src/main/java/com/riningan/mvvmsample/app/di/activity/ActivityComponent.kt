package com.riningan.mvvmsample.app.di.activity

import com.riningan.mvvmsample.presentation.details.DetailsFragment
import com.riningan.mvvmsample.presentation.list.ListFragment
import dagger.Subcomponent


@Subcomponent(modules = [NavigationModule::class])
@ActivityScope
interface ActivityComponent {
    fun inject(pokemonsListFragment: ListFragment)
    fun inject(pokemonDetailsFragment: DetailsFragment)
}