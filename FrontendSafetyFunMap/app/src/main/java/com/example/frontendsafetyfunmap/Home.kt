package com.example.frontendsafetyfunmap

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray

import retrofit2.Call
import retrofit2.http.GET

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.await
interface ApiService {
    @GET("/posts/")
    fun getAllPosts(): Call<List<PostModel>>
}

suspend fun getApiResponse(): List<PostModel> {
    try {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.100.20:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        return apiService.getAllPosts().await()
    } catch (e: Exception) {
        throw e
    }
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

        val scrollViewHome = view.findViewById<ScrollView>(R.id.scrollViewHome)
        val linearContainer = scrollViewHome.findViewById<LinearLayout>(R.id.linearContainer)
//        linearContainer.removeAllViews()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = getApiResponse()
                Log.d("start", response.toString())
                if (response.isNotEmpty()) {
                    response.forEach {
                        val post = it
                        Log.d("svfservf", post.username)

                        val cardView = CardView(linearContainer.context)
                        val layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            500
                        )
                        cardView.layoutParams = layoutParams
                        cardView.cardElevation = 4f
                        cardView.radius = 8f

                        val textView = TextView(cardView.context)
                        textView.text = post.username
                        textView.textSize = 70.0F
                        cardView.addView(textView)

                        linearContainer.addView(cardView)
                    }
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