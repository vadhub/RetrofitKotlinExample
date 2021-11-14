package com.vad.retrofitkotlinexample.screens.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

class ListFragment : Fragment() {

    lateinit var myRecycler: RecyclerView
    lateinit var retrofitService: RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retrofitService = Common.retrofitService
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.list_fragment, container, false)
        myRecycler = view.findViewById(R.id.myRecycler)
        myRecycler.layoutManager = LinearLayoutManager(view.context)
        getUsers()
        return view
    }

    fun getUsers() {
        retrofitService.getUsers().enqueue(object : Callback<MutableList<User>>{
            override fun onResponse(
                call: Call<MutableList<User>>,
                response: Response<MutableList<User>>
            ) {
                myRecycler.adapter = response.body()?.toList()?.let { UsersAdapter(it) }
            }

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }


}