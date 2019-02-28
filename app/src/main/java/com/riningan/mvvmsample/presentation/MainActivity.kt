package com.riningan.mvvmsample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.riningan.mvvmsample.R
import com.riningan.mvvmsample.presentation.pokemons_list.PokemonsListFragment


class MainActivity : AppCompatActivity() {
    var navController: NavController? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.navHostFragment)
    }

    override fun onStart() {
        super.onStart()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction
                .add(android.R.id.content, PokemonsListFragment())
                .commit()
    }
}