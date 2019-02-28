package com.riningan.mvvmsample.data.model


data class PokemonsResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)

data class Result(
    val name: String,
    val url: String
)