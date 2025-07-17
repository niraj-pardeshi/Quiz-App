package com.example.dailyroundsassignment.Model

data class Question(
    val id: String,
    val question: String,
    val options: List<String>,
    val correctAnswer: Int,
    val category: String? = null,
    val difficulty: String? = null
)
