package com.example.arkademi.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.arkademi.HomeActivity
import com.example.arkademi.LearnCreatorActivity
import com.example.arkademi.MainActivity
import com.example.arkademi.R

class ProfileFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)
        val buttonOne: Button = view.findViewById(R.id.learnMore_button)
        buttonOne.setOnClickListener{ openLearn()}
        return  view
    }

    private fun openLearn() {
        val intent = Intent(activity, LearnCreatorActivity::class.java)
        startActivity(intent)
    }

}