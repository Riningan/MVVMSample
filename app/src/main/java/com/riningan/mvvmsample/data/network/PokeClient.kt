package com.riningan.mvvmsample.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class PokeClient {
    private val mApi: PokeApi


    init {
        val okHttpClient = OkHttpClient().newBuilder()
                .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .build()

        mApi = Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokeApi::class.java)
    }


    fun getApi() = mApi


    companion object {
        private const val TIMEOUT = 30000L
        var URL = "https://pokeapi.co/api/v2/"
    }
}