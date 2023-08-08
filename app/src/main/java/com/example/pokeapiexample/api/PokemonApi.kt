package com.example.pokeapiexample.api

import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int): PokemonListResponse

}
