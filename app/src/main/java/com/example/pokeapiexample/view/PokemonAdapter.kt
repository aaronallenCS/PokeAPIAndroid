package com.example.pokeapiexample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapiexample.Pokemon
import com.example.pokeapiexample.R
import com.squareup.picasso.Picasso


// TODO 4: This is finally where you hook the data up from the api, to your android views. The Adapter. In the onBindViewHolder, all you're doing is hooking up the data you collected from the API, to the views you created.
class PokemonAdapter(
    private val pokemonList: List<Pokemon>
) : RecyclerView.Adapter<PokemonViewHolder>()
{

    //create the adapter like normal
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        //getting the current position of the list, aka the Pokemon

        val pokemon = pokemonList?.get(position)

        //get the pokemons name and fill it with the view's textview
        holder.nameTextView.text = pokemon?.name

        // Load image with Picasso - we don't want to do any api work here, we just want
        // to pass the imageUrl (which we already filled in the api service class)
        // into the imageView
        Picasso.get()
            .load(pokemon?.url)
            .into(holder.imageView)
    }

    override fun getItemCount() = pokemonList?.size ?: 0
}