package com.riningan.mvvmsample

import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.data.model.PokemonsResponse
import com.riningan.mvvmsample.data.model.Result
import com.riningan.mvvmsample.data.model.Species
import com.riningan.mvvmsample.data.model.Sprites


val pokemonResponse1 = PokemonResponse(
        listOf(),
        0,
        listOf(),
        listOf(),
        0,
        listOf(),
        1,
        true,
        "",
        listOf(),
        "pokemon1",
        1,
        Species("", ""),
        Sprites("", "", "", "", "", "", "", ""),
        listOf(),
        listOf(),
        0)

val pokemonResponse2 = PokemonResponse(
        listOf(),
        0,
        listOf(),
        listOf(),
        0,
        listOf(),
        2,
        true,
        "",
        listOf(),
        "pokemon2",
        2,
        Species("", ""),
        Sprites("", "", "", "", "", "", "", ""),
        listOf(),
        listOf(),
        0)

val pokemonResponse3 = PokemonResponse(
        listOf(),
        0,
        listOf(),
        listOf(),
        0,
        listOf(),
        3,
        true,
        "",
        listOf(),
        "pokemon3",
        3,
        Species("", ""),
        Sprites("", "", "", "", "", "", "", ""),
        listOf(),
        listOf(),
        0)

val pokemonResponse4 = PokemonResponse(
        listOf(),
        0,
        listOf(),
        listOf(),
        0,
        listOf(),
        4,
        true,
        "",
        listOf(),
        "pokemon4",
        4,
        Species("", ""),
        Sprites("", "", "", "", "", "", "", ""),
        listOf(),
        listOf(),
        0)

val pokemonsResponse1 = PokemonsResponse(2,
        "pokemonsResponse2",
        "",
        listOf(Result(pokemonResponse1.name, ""), Result(pokemonResponse2.name, "")))

val pokemonsResponse2 = PokemonsResponse(2,
        "",
        "pokemonsResponse1",
        listOf(Result(pokemonResponse3.name, ""), Result(pokemonResponse4.name, "")))