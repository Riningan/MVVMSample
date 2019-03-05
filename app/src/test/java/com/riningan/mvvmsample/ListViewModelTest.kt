package com.riningan.mvvmsample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.data.repository.PokemonRepository
import com.riningan.mvvmsample.presentation.list.ListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.awaitility.Awaitility.await
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.verify
import java.util.concurrent.TimeUnit


@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class ListViewModelTest {
    private lateinit var mMockPokemonRepository: PokemonRepository
    private lateinit var mListViewModel: ListViewModel
    private val mMainThreadSurrogate = newSingleThreadContext("UI thread")

    @get: Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        Dispatchers.setMain(mMainThreadSurrogate)
        mMockPokemonRepository = mock {
            onBlocking { getPokemons(0, 10) } doReturn listOf(
                pokemonResponse1,
                pokemonResponse2,
                pokemonResponse3,
                pokemonResponse4,
                pokemonResponse1,
                pokemonResponse2,
                pokemonResponse3,
                pokemonResponse4,
                pokemonResponse1,
                pokemonResponse2
            )
        }
        mListViewModel = ListViewModel(mMockPokemonRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mMainThreadSurrogate.close()
    }


    @Test
    fun getPokemons() {
        mListViewModel.pokemons.observeForever {
            await().atMost(5, TimeUnit.SECONDS)
                .ignoreExceptions()
                .untilAsserted {
                    assertEquals(it.size, 10)
                }
            assertEquals(it[0], pokemonResponse1)
            assertEquals(it[1], pokemonResponse2)
            assertEquals(it[2], pokemonResponse3)
            assertEquals(it[3], pokemonResponse4)
            assertEquals(it[4], pokemonResponse1)
            assertEquals(it[5], pokemonResponse2)
            assertEquals(it[6], pokemonResponse3)
            assertEquals(it[7], pokemonResponse4)
            assertEquals(it[8], pokemonResponse1)
            assertEquals(it[9], pokemonResponse2)
        }
    }

    @Test
    fun getListItemClick() {
        val observer = mock<Observer<PokemonResponse>>()

        mListViewModel.listItemClick.observeForever(observer)
        mListViewModel.listItemClick.value = pokemonResponse1

        verify(observer).onChanged(pokemonResponse1)
    }
}