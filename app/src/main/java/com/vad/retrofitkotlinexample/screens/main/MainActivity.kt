package com.vad.retrofitkotlinexample.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vad.retrofitkotlinexample.R
import com.vad.retrofitkotlinexample.screens.list.ListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBar?.setDisplayHomeAsUpEnabled(true)
        supportFragmentManager
            .beginTransaction()
            .addToBackStack("listFragment")
            .replace(R.id.fragment_container, ListFragment())
            .commit()
    }


}