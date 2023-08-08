package com.example.pokeapiexample.api

import android.util.Log
import com.example.pokeapiexample.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO 3: Final step of the data portion of the api. Use retrofit to get the api - now you want to define what hapens when you get a list of pokemon


class PokemonApiService {

    //this is consuming the api in retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    suspend fun getPokemonList(limit: Int): List<Pokemon> {

        // Make API request with Retrofit
        val apiResponse = retrofit.create(PokemonApi::class.java)
            .getPokemonList(limit)
        val results = apiResponse.results

        // Map response to Pokemon
        return results.map {

            // Get id from url
            val url = it.url

            //this is just logic to parse the url, split the url into different arrays based on the slashses
            val sections = url?.split("/")

            //the idArray willl be the second to last element in the sections array
            val idSection = sections?.get(sections.size-2)

            //then just get the id
            val id = idSection?.toInt()

            // Construct image URL
            val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png"

            Pokemon(id, it.name, imageUrl)

        }
    }
}