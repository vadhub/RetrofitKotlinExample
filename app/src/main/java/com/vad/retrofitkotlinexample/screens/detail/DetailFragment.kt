package com.vad.retrofitkotlinexample.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.Fragment
import com.vad.retrofitkotlinexample.R

class DetailFragment : Fragment() {

    private lateinit var userIdTextView: TextView
    private lateinit var titleTextView: TextView
    private lateinit var bodyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.actionBar?.title = arguments?.getInt("id").toString()

        var view: View = inflater.inflate(R.layout.detail_fragment, container, false)

        userIdTextView = view.findViewById(R.id.textViewIdUser)
        titleTextView = view.findViewById(R.id.textViewTitleDetail)
        bodyTextView = view.findViewById(R.id.textViewBody)

        //userIdTextView.text = arguments?.getInt("id").toString()
        titleTextView.text = arguments?.getString("title")
        bodyTextView.text = arguments?.getString("body")
        return view
    }
}
