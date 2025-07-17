package com.example.dailyroundsassignment

import androidx.compose.ui.unit.max
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailyroundsassignment.Model.QuizState
import com.example.dailyroundsassignment.QuizRepository.QuizRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class QuizViewModel(): ViewModel() {
    val repository: QuizRepository = QuizRepository()

    private val _quizState = MutableStateFlow(QuizState())
    val quizState: StateFlow<QuizState> = _quizState.asStateFlow()

    init {
        loadQuestions()
    }

    fun loadQuestions(){
        viewModelScope.launch {
            val questions = repository.getQuestions()
            _quizState.value = _quizState.value.copy(
                questions = questions,
                answeredQuestions = MutableList(questions.size) { false }
            )
        }
    }

    fun selectOption(index: Int){
        val currentState = _quizState.value
        val currentQuestion = _quizState.value.currentQuestion ?: return
        val isCorrect = index == currentQuestion.correctAnswer
        val correctAns = if(isCorrect) currentState.correctAnswers + 1  else currentState.correctAnswers
        val streak = if(isCorrect) currentState.currentStreak + 1 else 0
        val longestStreak = kotlin.math.max(currentState.longestStreak, streak)
        currentState.answeredQuestions[currentState.currentQuestionIndex] = true
        _quizState.value = currentState.copy(
            selectedOption = index,
            isAnswerRevealed = true,
            correctAnswers = correctAns,
            currentStreak = streak,
            longestStreak = longestStreak,
            isStreakActive = streak >= 3
        )
    }


    fun skipQuestion(){
        val current = _quizState.value;
        _quizState.value = current.copy(
            skippedQuestions = current.skippedQuestions + 1,
            currentStreak = 0,
            isStreakActive = false
        )
        nextQuestion()
    }

    fun nextQuestion(){
        val current = _quizState.value
        val nextIndex = current.currentQuestionIndex + 1;
        if(nextIndex >= current.questions.size){
            _quizState.value = current.copy(
                isQuizCompleted = true
            )
        } else {
            _quizState.value = current.copy(
                currentQuestionIndex = nextIndex,
                selectedOption = null,
                isAnswerRevealed = false
            )
        }
    }

    fun restartQuiz(){
        _quizState.value = QuizState(
            questions = _quizState.value.questions,
            answeredQuestions = MutableList(_quizState.value.questions.size) { false }
        )
    }

}