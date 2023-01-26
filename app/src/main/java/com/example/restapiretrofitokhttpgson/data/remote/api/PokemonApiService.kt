package com.example.restapiretrofitokhttpgson.data.remote.api

import com.example.restapiretrofitokhttpgson.data.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonApiService  {

    @GET ("pokemon")
    fun getPokemon(): Call<PokemonResponse>
}