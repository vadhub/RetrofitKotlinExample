package com.vad.retrofitkotlinexample.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.vad.retrofitkotlinexample.R
import com.vad.retrofitkotlinexample.screens.contract.HasTitle
import com.vad.retrofitkotlinexample.screens.list.ListFragment

class MainActivity : AppCompatActivity() {

    private val currentFragment: Fragment? get() = supportFragmentManager.findFragmentById(R.id.fragment_container)

    private val fragmentListener = object: FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentViewCreated(
            fm: FragmentManager,
            f: Fragment,
            v: View,
            savedInstanceState: Bundle?
        ) {
            super.onFragmentViewCreated(fm, f, v, savedInstanceState)
            updateOnUI()
        }
    }

    private fun updateOnUI() {
        val fragment = currentFragment
        title = if (fragment is HasTitle) {
            fragment.getTitle()
        } else {
            getString(R.string.app_name)
        }

        if (supportFragmentManager.backStackEntryCount > 0) {
            actionBar?.setDisplayHomeAsUpEnabled(true)
            actionBar?.setDisplayHomeAsUpEnabled(true)
        } else {
            actionBar?.setDisplayHomeAsUpEnabled(false)
            actionBar?.setDisplayHomeAsUpEnabled(false)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentListener, false)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack("listFragment")
            .replace(R.id.fragment_container, ListFragment())
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        supportFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentListener)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        updateOnUI()
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}