package com.riningan.mvvmsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.riningan.mvvmsample.presentation.pokemons_list.PokemonsListFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction
            .add(android.R.id.content, PokemonsListFragment())
            .commit()
    }
}