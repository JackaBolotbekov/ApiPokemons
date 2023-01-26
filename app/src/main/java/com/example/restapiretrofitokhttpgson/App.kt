package com.example.restapiretrofitokhttpgson

import android.app.Application
import com.example.restapiretrofitokhttpgson.data.remote.RetrofitClient
import com.example.restapiretrofitokhttpgson.data.remote.api.PokemonApiService

class App : Application() {

    companion object{
        val retrofitClient = RetrofitClient()
    }

    override fun onCreate() {
        super.onCreate()
    }
}