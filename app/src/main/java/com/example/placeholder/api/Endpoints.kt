package com.example.placeholder.api

import com.example.placeholder.model.Users
import retrofit2.Call
import retrofit2.http.GET


interface Endpoints {

    @GET("users")
    fun getAllUsers() : Call<List<Users>>

}