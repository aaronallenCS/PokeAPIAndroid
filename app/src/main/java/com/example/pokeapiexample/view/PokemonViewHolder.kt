package com.example.pokeapiexample.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapiexample.R
// TODO 5: ViewHolder is pretty easy, this is what the recyclerview is going to show

class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    val imageView: ImageView = itemView.findViewById(R.id.imageView)
}