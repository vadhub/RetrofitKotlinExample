package com.vad.retrofitkotlinexample.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vad.retrofitkotlinexample.R
import com.vad.retrofitkotlinexample.screens.list.ListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager
            .beginTransaction()
            .addToBackStack("listFragment")
            .replace(R.id.fragment_container, ListFragment())
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(supportFragmentManager.backStackEntryCount != 0) supportFragmentManager.popBackStack()
    }


}