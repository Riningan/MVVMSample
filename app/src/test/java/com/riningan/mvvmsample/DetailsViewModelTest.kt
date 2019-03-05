package com.riningan.mvvmsample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verifyBlocking
import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.data.repository.PokemonRepository
import com.riningan.mvvmsample.presentation.details.DetailsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class DetailsViewModelTest {
    private lateinit var mMockPokemonRepository: PokemonRepository
    private lateinit var mDetailsViewModel: DetailsViewModel
    private val mMainThreadSurrogate = newSingleThreadContext("UI thread")

    @get: Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        Dispatchers.setMain(mMainThreadSurrogate)
        mMockPokemonRepository = mock {
            onBlocking { getPokemon(pokemonResponse1.name) } doReturn pokemonResponse1
        }
        mDetailsViewModel = DetailsViewModel(mMockPokemonRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mMainThreadSurrogate.close()
    }


    @Test
    fun pokemon() {
        val observer = mock<Observer<PokemonResponse>>()

        mDetailsViewModel.pokemon.observeForever(observer)
        mDetailsViewModel.start(pokemonResponse1.name)

        verifyBlocking(observer) { onChanged(pokemonResponse1) }
    }

    @Test
    fun backClick() {
        val observer = mock<Observer<Boolean>>()

        mDetailsViewModel.backClick.observeForever(observer)
        mDetailsViewModel.backClick.value = true

        verifyBlocking(observer) { onChanged(true) }
    }
}