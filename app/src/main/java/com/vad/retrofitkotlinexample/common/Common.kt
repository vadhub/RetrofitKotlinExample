package com.vad.retrofitkotlinexample.common

import com.vad.retrofitkotlinexample.api.RetrofitClient
import com.vad.retrofitkotlinexample.api.RetrofitService

object Common {
    private const val BASE_URS = "https://jsonplaceholder.typicode.com"
    val retrofitService: RetrofitService get() = RetrofitClient.getClient(BASE_URS).create(
        RetrofitService::class.java)
}