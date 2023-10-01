package com.example.frontendsafetyfunmap

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class Home: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val clickHereButton = view.findViewById<Button>(R.id.buttonClickHere)
        val txtViewHome = view.findViewById<TextView>(R.id.textViewHome)

        clickHereButton?.setOnClickListener{
            if (txtViewHome?.text?.equals("") == true) {
                txtViewHome.text = "Text showed"
            } else {
                txtViewHome?.text = ""
            }
        }

        return view
    }
}