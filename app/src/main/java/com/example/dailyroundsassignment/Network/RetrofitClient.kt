package com.example.dailyroundsassignment.Network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private const val BASE_URL = "https://gist.githubusercontent.com/dr-samrat/"
    private var retrofit: Retrofit? = null

    val apiService: QuizApiService by lazy {
        getRetrofit().create(QuizApiService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        if( retrofit == null ){
            val client = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}
