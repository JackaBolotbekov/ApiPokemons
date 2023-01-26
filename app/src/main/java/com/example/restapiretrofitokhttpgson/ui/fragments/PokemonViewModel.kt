package com.example.restapiretrofitokhttpgson.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restapiretrofitokhttpgson.App
import com.example.restapiretrofitokhttpgson.data.model.Pokemon
import com.example.restapiretrofitokhttpgson.data.repository.PokemonRepository

class PokemonViewModel : ViewModel() {

    private val repository = PokemonRepository(App.retrofitClient.pokemonApiService)

    private val _pokemonLiveData = MutableLiveData<List<Pokemon>>()
    val pokemonLiveData : LiveData<List<Pokemon>> = _pokemonLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData : LiveData<String> = _errorLiveData

    init {
        getPokemon()
    }

    fun getPokemon() {
        repository.getPokemon(
            onSuccess = {
                _pokemonLiveData.value = it
            },
            onFailure = {
                _errorLiveData.value = it
            }
        )
    }
}