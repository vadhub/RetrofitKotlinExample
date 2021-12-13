package com.vad.retrofitkotlinexample.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.Fragment
import com.vad.retrofitkotlinexample.R
import com.vad.retrofitkotlinexample.screens.contract.HasTitle

class DetailFragment : Fragment(), HasTitle {

    private lateinit var userIdTextView: TextView
    private lateinit var titleTextView: TextView
    private lateinit var bodyTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.detail_fragment, container, false)

        println(activity?.supportFragmentManager?.backStackEntryCount)

        userIdTextView = view.findViewById(R.id.textViewIdUser)
        titleTextView = view.findViewById(R.id.textViewTitleDetail)
        bodyTextView = view.findViewById(R.id.textViewBody)

        userIdTextView.text = ""
        titleTextView.text = arguments?.getString("title")
        bodyTextView.text = arguments?.getString("body")
        return view
    }

    override fun getTitle(): String {
        return arguments?.getInt("id").toString()
    }
}
