package com.example.placeholder.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {


    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getEndpoints() : Endpoints {
        return getRetrofit().create(Endpoints::class.java)
    }

}