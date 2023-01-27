package com.example.restapiretrofitokhttpgson.data.remote.api

import com.example.restapiretrofitokhttpgson.data.model.PokemonResponse
import com.example.restapiretrofitokhttpgson.data.model.detail.AboutPokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService  {

    @GET ("pokemon")
    fun getPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): Call<PokemonResponse>

    @GET ("pokemon/{name}")
    fun getSinglePokemon(
        @Path("name") name: String
    ) : Call<AboutPokemon>
}