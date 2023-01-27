package com.example.restapiretrofitokhttpgson.data.model.detail

import com.google.gson.annotations.SerializedName

data class AboutPokemon(
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String = "",
    @SerializedName("base_experience")
    val baseExperience: Int = 0,
    @SerializedName("weight")
    val weight: Int = 0,
    @SerializedName("is_default")
    val isDefault: Boolean = false,
    @SerializedName("sprites")
    val sprites: Sprites,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: Int = 0,
   @SerializedName("height")
    val height: Int = 0,
    @SerializedName("order")
    val order: Int = 0
)