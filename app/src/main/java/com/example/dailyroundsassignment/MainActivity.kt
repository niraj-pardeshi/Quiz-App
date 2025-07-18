package com.example.dailyroundsassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.dailyroundsassignment.Navigation.Navgraph
import com.example.dailyroundsassignment.Screens.QuestionScreen
import com.example.dailyroundsassignment.Screens.ResultScreen
import com.example.dailyroundsassignment.ui.theme.DailyRoundsAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DailyRoundsAssignmentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: QuizViewModel = viewModel()
                    QuizApp(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun QuizApp(viewModel: QuizViewModel) {
    val navController = rememberNavController()
    Navgraph(
        navController = navController,
        modifier = Modifier
    )
}