package com.example.dailyroundsassignment.Navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dailyroundsassignment.QuizViewModel
import com.example.dailyroundsassignment.Screens.LoadingScreen
import com.example.dailyroundsassignment.Screens.QuestionScreen
import com.example.dailyroundsassignment.Screens.ResultScreen

@Composable
fun Navgraph(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: QuizViewModel = viewModel()
) {
    val quizState by viewModel.quizState.collectAsState()
    NavHost(
        navController,
        startDestination = Routes.Loading.route,
    ) {
        composable(Routes.Loading.route){
            LoadingScreen(
                onDataLoaded = {
                    navController.navigate(Routes.Questions.route) {
                        popUpTo(Routes.Loading.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.Questions.route){
            QuestionScreen(
                quizState = quizState,
                onOptionSelected = viewModel::selectOption,
                onSkipQuestion = viewModel::skipQuestion,
                onNextQuestion = {
                    if (quizState.currentQuestionIndex >= quizState.questions.size - 1) {
                        navController.navigate(Routes.Result.route)
                    } else {
                        viewModel.nextQuestion()
                    }
                }
            )
        }
        composable(Routes.Result.route){
            ResultScreen(
                quizState = quizState,
                onRestart = {
                    viewModel.restartQuiz()
                    navController.navigate(Routes.Questions.route) {
                        popUpTo(Routes.Result.route) { inclusive = true }
                    }
                }
            )
        }
    }
}