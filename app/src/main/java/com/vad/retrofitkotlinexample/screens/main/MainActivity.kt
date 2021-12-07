package com.vad.retrofitkotlinexample.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vad.retrofitkotlinexample.R
import com.vad.retrofitkotlinexample.screens.list.ListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .addToBackStack("listFragment")
            .replace(R.id.fragment_container, ListFragment())
            .commit()
    }

    override fun onBackPressed() {
        supportFragmentManager.popBackStack()
        println(supportFragmentManager.backStackEntryCount)
    }


}