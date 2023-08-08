package com.example.pokeapiexample.api

import com.example.pokeapiexample.Pokemon

// TODO 2: This would be the next step, you want to get the json data into List format, using the data class you made in todo 1

//takes the list of json into one list of Pokemon named "result"
data class PokemonListResponse(
    val results: List<Pokemon>
)