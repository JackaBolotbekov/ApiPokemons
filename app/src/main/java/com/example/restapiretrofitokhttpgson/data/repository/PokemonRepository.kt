package com.example.restapiretrofitokhttpgson.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.restapiretrofitokhttpgson.data.model.Pokemon
import com.example.restapiretrofitokhttpgson.data.model.PokemonResponse
import com.example.restapiretrofitokhttpgson.data.remote.api.PokemonApiService
import retrofit2.Call
import retrofit2.Response

class PokemonRepository (private val pokemonApiService: PokemonApiService) {

    fun getPokemon(
        onSuccess: (pokemonList: List<Pokemon>?) -> Unit,
        onFailure: (message: String) -> Unit,
        offset: Int,
        limit: Int
    ) {
        pokemonApiService.getPokemon(offset = offset, limit = limit).enqueue(object : retrofit2.Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                if (response.isSuccessful){
                    response.body()?.let {
                        onSuccess(it.results)
                    }
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                t.localizedMessage?.let {
                    onFailure(it)
                }
            }
        })
    }
}