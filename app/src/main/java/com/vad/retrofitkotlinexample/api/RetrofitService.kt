package com.vad.retrofitkotlinexample.api

import com.vad.retrofitkotlinexample.entity.User
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("/posts")
    fun getUsers(): Call<User>
}