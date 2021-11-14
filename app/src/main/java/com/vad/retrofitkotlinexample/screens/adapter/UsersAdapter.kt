package com.vad.retrofitkotlinexample.screens.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vad.retrofitkotlinexample.R
import com.vad.retrofitkotlinexample.entity.User

class UsersAdapter(private val users: List<User>) : RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.id?.text = users[position].id.toString()
        holder.title?.text = users[position].title
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id: TextView? = null
        var title: TextView? = null

        init {
            id = itemView.findViewById(R.id.textViewId)
            title = itemView.findViewById(R.id.textViewTitle)
        }
    }
}