package com.example.restapiretrofitokhttpgson.data.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(@SerializedName("next")
                           val next: String = "",
                           @SerializedName("previous")
                           val previous: String?,
                           @SerializedName("count")
                           val count: Int = 0,
                           @SerializedName("results")
                           val results: List<Pokemon>?)