package com.example.restapiretrofitokhttpgson.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.restapiretrofitokhttpgson.data.model.Pokemon
import com.example.restapiretrofitokhttpgson.databinding.ItemCountBinding

class PokemonAdapter : ListAdapter<Pokemon, PokemonAdapter.PokemonViewHolder> (diffUtil) {

    inner class PokemonViewHolder(val binding: ItemCountBinding) : ViewHolder(binding.root) {
        fun onBind(item: Pokemon) {
            val pokemonId = item.url.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/", "").toInt()
            Glide.with(binding.ivImage.context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$pokemonId.png")
                .into(binding.ivImage)

            binding.tvText.text = item.name.replaceFirstChar {
                it.uppercase()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            ItemCountBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Pokemon>(){
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
                return oldItem.name == newItem.name
            }

        }
    }
}