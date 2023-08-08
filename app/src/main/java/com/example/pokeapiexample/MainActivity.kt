package com.example.pokeapiexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokeapiexample.api.PokemonApiService
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapiexample.view.PokemonAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO 6: MainActivity is defining all of your views, getting the information and most importantly, setting the adapter for the recyclerview you're using.

class MainActivity : AppCompatActivity() {

    //get the api service, which gets the list of pokemon information
    private val pokemonApiService = PokemonApiService()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        //this handles the information on another thread, looks scary

        lifecycleScope.launch {

            //this is apart of coroutines - you're getting a list of 150 api responses
            val pokemonList = pokemonApiService.getPokemonList(150)

            withContext(Dispatchers.Main) {
                //the recyclerview is now filled with information, that you get from the adapter
                recyclerView.adapter = PokemonAdapter(pokemonList)
            }
        }
    }
}