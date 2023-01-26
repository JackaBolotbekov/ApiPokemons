package com.example.restapiretrofitokhttpgson.data.model

import com.google.gson.annotations.SerializedName

data class Pokemon(@SerializedName("name")
                       val name: String,
                   @SerializedName("url")
                       val url: String)