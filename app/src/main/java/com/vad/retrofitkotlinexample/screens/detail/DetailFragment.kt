package com.vad.retrofitkotlinexample.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.vad.retrofitkotlinexample.R

class DetailFragment : Fragment() {

    private var userId: String =""

    private lateinit var userIdTextView: TextView
    private lateinit var titleTextView: TextView
    private lateinit var bodyTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.detail_fragment, container, false)
        userIdTextView = view.findViewById(R.id.textViewIdUser)
        titleTextView = view.findViewById(R.id.textViewTitle)
        bodyTextView = view.findViewById(R.id.textViewBody)

        arguments?.getString("id")?.let { userId = it }

        userIdTextView.text = userId
        titleTextView.text = arguments?.getString("title").toString()
        bodyTextView.text = arguments?.getString("body").toString()
        return view
    }
}