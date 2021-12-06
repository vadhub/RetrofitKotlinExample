package com.vad.retrofitkotlinexample.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vad.retrofitkotlinexample.R

class DetailFragment : Fragment() {

    private var userId: String =""
    private var title: String = ""
    private var body: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.detail_fragment, container, false)

        return view
    }
}