package com.vad.retrofitkotlinexample.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vad.retrofitkotlinexample.R
import com.vad.retrofitkotlinexample.api.RetrofitService
import com.vad.retrofitkotlinexample.common.Common
import com.vad.retrofitkotlinexample.entity.User
import com.vad.retrofitkotlinexample.screens.adapter.UsersAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var retrofitService: RetrofitService
    lateinit var myRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecycler = findViewById(R.id.myRecycler)
        retrofitService = Common.retrofitService

        myRecycler.layoutManager = LinearLayoutManager(this)

        getUsers()
    }

    private fun getUsers() {
        retrofitService.getUsers().enqueue(object : Callback<MutableList<User>> {
            override fun onResponse(call: Call<MutableList<User>>, response: Response<MutableList<User>>) {
                myRecycler.adapter = response.body()?.let { UsersAdapter(it.toList()) }
            }

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
}