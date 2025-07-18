package com.example.dailyroundsassignment.Model

data class QuizState(
    val questions: List<Question> = emptyList(),
    val currentQuestionIndex: Int = 0,
    val selectedOption: Int? = null,
    val isAnswerRevealed: Boolean = false,
    val correctAnswers: Int = 0,
    val skippedQuestions: Int = 0,
    val currentStreak: Int = 0,
    val longestStreak: Int = 0,
    val isStreakActive: Boolean = false,
    val answeredQuestions: MutableList<Boolean> = mutableListOf(),
    val isQuizCompleted: Boolean = false,
    val isLoading: Boolean = false, 
    val error: String? = null
) {
    val currentQuestion: Question?
        get() = if (currentQuestionIndex < questions.size) questions[currentQuestionIndex] else null

    val totalQuestions: Int
        get() = questions.size

    val progress: Float
        get() = if (totalQuestions > 0) (currentQuestionIndex + 1).toFloat() / totalQuestions else 0f
}
