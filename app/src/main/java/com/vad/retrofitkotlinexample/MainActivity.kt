package com.vad.retrofitkotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.vad.retrofitkotlinexample.api.RetrofitService
import com.vad.retrofitkotlinexample.common.Common
import com.vad.retrofitkotlinexample.entity.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity() : AppCompatActivity() {

    lateinit var retrofitService: RetrofitService
    lateinit var textViewUsers: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewUsers = findViewById(R.id.textRequest)
        retrofitService = Common.retrofitService
    }

    fun onGetRequest(view: View) {

    }

    fun getUsers() {
        retrofitService.getUsers().enqueue(object : Callback<MutableList<User>> {
            override fun onResponse(call: Call<MutableList<User>>, response: Response<MutableList<User>>) {
                response.body()?.toList()?.map { textViewUsers.text = it.toString() }
            }

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
}