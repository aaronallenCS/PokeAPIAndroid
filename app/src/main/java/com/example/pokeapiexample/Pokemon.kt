package com.example.pokeapiexample


// TODO 1: This is always where you want to start with apis, define what information you want first


// the data class for the api
// whenever you want to consume data from an api
// you always want a data class that models the information you want
// you want the id, name, and imageUrl, so you have to define it here.
data class Pokemon(
    val id: Int?,
    val name: String,
    val url: String?
)
