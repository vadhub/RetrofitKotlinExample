package com.vad.retrofitkotlinexample.api

import com.vad.retrofitkotlinexample.entity.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiRequests {

    @GET("/posts")
    fun getUsers(): Call<User>
}