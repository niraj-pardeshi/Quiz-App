package com.example.dailyroundsassignment.Network

import com.example.dailyroundsassignment.Model.Question
import retrofit2.Response
import retrofit2.http.GET

interface QuizApiService {
    @GET("53846277a8fcb034e482906ccc0d12b2/raw")
    suspend fun getQuestions(): Response<List<Question>>
}