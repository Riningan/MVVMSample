package com.riningan.mvvmsample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.riningan.mvvmsample.R
import com.riningan.mvvmsample.app.App


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.createActivityComponent(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        App.clearActivityComponent()
    }
}