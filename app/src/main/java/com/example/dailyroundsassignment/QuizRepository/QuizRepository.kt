package com.example.dailyroundsassignment.QuizRepository

import com.example.dailyroundsassignment.Model.APIResult
import com.example.dailyroundsassignment.Model.Question
import com.example.dailyroundsassignment.Network.QuizApiService
import javax.inject.Inject

class QuizRepository @Inject constructor(
    private val apiService: QuizApiService
) {
    suspend fun getQuestions(): APIResult<List<Question>>{
        return try {
            val response = apiService.getQuestions()
            if(response.isSuccessful){
                val questions = response.body()
                if (questions != null) {
                    APIResult.Success(questions)
                } else {
                    APIResult.Error("Empty response")
                }
            } else {
                APIResult.Error("Error: ${response.code()} - ${response.message()}")
            }
        } catch (e: Exception) {
            APIResult.Error("Network error: ${e.message}")
        }
    }
}