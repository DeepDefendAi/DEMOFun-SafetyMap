package com.example.frontendsafetyfunmap

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Call
import retrofit2.http.GET

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.await
interface ApiService {
    @GET("/posts/")
    fun getAllPosts(): Call<List<PostModel>>
}

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

        val txtViewHome = view.findViewById<TextView>(R.id.textViewHome)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.100.20:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getAllPosts().await()
                if (response.isNotEmpty()) {
                    txtViewHome.text = response[0].username
                } else {
                    // Handle an error response (non-2xx status code)
                }
            } catch (e: Exception) {
                // Handle network or other exceptions
            }
        }

        return view
    }
}