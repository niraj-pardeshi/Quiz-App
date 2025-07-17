package com.example.dailyroundsassignment.QuizRepository

import com.example.dailyroundsassignment.Model.Question
import kotlinx.coroutines.delay
import kotlinx.coroutines.time.delay

class QuizRepository {
    suspend fun getQuestions(): List<Question>{
        delay(1000)
        return listOf(
            Question(
                id = "11",
                question = "What is the boiling point of water at sea level in Celsius?",
                options = listOf("90°C", "100°C", "110°C", "120°C"),
                correctAnswer = 1,
                category = "Science",
                difficulty = "Easy"
            ),
            Question(
                id = "12",
                question = "Which element has the chemical symbol 'O'?",
                options = listOf("Oxygen", "Gold", "Osmium", "Oxide"),
                correctAnswer = 0,
                category = "Chemistry",
                difficulty = "Easy"
            ),
            Question(
                id = "13",
                question = "What is the value of Pi up to 2 decimal places?",
                options = listOf("3.14", "3.15", "3.13", "3.12"),
                correctAnswer = 0,
                category = "Mathematics",
                difficulty = "Easy"
            ),
            Question(
                id = "14",
                question = "Which Indian cricketer is known as 'Captain Cool'?",
                options = listOf("Virat Kohli", "MS Dhoni", "Rohit Sharma", "Sachin Tendulkar"),
                correctAnswer = 1,
                category = "Sports",
                difficulty = "Easy"
            ),
            Question(
                id = "15",
                question = "What does HTTP stand for?",
                options = listOf("HyperText Transfer Protocol", "HighText Transfer Protocol", "Hyper Transfer Text Protocol", "None"),
                correctAnswer = 0,
                category = "Technology",
                difficulty = "Medium"
            ),
            Question(
                id = "16",
                question = "Which country is known as the Land of the Rising Sun?",
                options = listOf("India", "Japan", "China", "South Korea"),
                correctAnswer = 1,
                category = "Geography",
                difficulty = "Easy"
            ),
            Question(
                id = "17",
                question = "Which gas is most abundant in the Earth's atmosphere?",
                options = listOf("Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"),
                correctAnswer = 2,
                category = "Science",
                difficulty = "Medium"
            ),
            Question(
                id = "18",
                question = "Who is the author of 'The Alchemist'?",
                options = listOf("J.K. Rowling", "Paulo Coelho", "Dan Brown", "Stephen King"),
                correctAnswer = 1,
                category = "Literature",
                difficulty = "Medium"
            ),
            Question(
                id = "19",
                question = "What is the square root of 144?",
                options = listOf("10", "11", "12", "13"),
                correctAnswer = 2,
                category = "Mathematics",
                difficulty = "Easy"
            ),
            Question(
                id = "20",
                question = "Which Indian city is known as the 'Silicon Valley of India'?",
                options = listOf("Hyderabad", "Bangalore", "Mumbai", "Delhi"),
                correctAnswer = 1,
                category = "General Knowledge",
                difficulty = "Easy"
            )
        )
    }
}