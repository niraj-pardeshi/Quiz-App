package com.example.dailyroundsassignment.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyroundsassignment.Model.QuizState
import kotlinx.coroutines.delay

@Composable
fun QuestionScreen(
    quizState: QuizState,
    onNextQuestion: () -> Unit,
    onSkipQuestion: () -> Unit,
    onOptionSelected: (Int) -> Unit
) {
    val currentQuestion = quizState.currentQuestion

    LaunchedEffect(quizState.isAnswerRevealed) {
        if (quizState.isAnswerRevealed) {
            delay(1000)
            onNextQuestion()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        QuizHeader(
            currentQuestion = quizState.currentQuestionIndex + 1,
            totalQuestions = quizState.totalQuestions,
            progress = quizState.progress,
            streak = quizState.currentStreak,
            isStreakActive = quizState.isStreakActive,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Card(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Text(
                text = currentQuestion?.question ?: "",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(2.dp))
            currentQuestion?.options?.forEachIndexed { index, option ->
                OptionCard(
                    option,
                    index = index,
                    isSelected = quizState.selectedOption == index,
                    isCorrect = index == currentQuestion.correctAnswer,
                    isRevealed = quizState.isAnswerRevealed,
                    onclick = { onOptionSelected(index) }
                )
            }
            OutlinedButton(
                onClick = { onSkipQuestion() },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp, vertical = 20.dp)
            ) {
                Text("Skip Question")
            }
        }
    }

}

@Composable
fun OptionCard(
    option: String,
    index: Int,
    isSelected: Boolean,
    isCorrect: Boolean,
    isRevealed: Boolean,
    onclick: ()-> Unit
){
    val backgroundColor = when {
        isRevealed && isCorrect -> Color(0xFF4CAF50)
        isRevealed && isSelected && !isCorrect -> Color(0xFFF44336)
        isSelected && !isRevealed -> MaterialTheme.colorScheme.primaryContainer
        else -> MaterialTheme.colorScheme.surface
    }

    val textColor = when {
        isRevealed && (isCorrect || (isSelected && !isCorrect)) -> Color.White
        isSelected && !isRevealed -> MaterialTheme.colorScheme.onPrimaryContainer
        else -> MaterialTheme.colorScheme.onSurface
    }
    Card(
        modifier = Modifier.fillMaxWidth().padding(12.dp)
            .clickable{ onclick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = if(isSelected) 8.dp else 4.dp
        ),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
    ) {
        Text(
            text = option,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            fontSize = 16.sp,
            color = textColor,
            fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal
        )
    }

}

@Composable
fun QuizHeader(
    currentQuestion: Int,
    totalQuestions: Int,
    progress: Float,
    streak: Int,
    isStreakActive: Boolean
){
    Column(
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Question ${currentQuestion} of ${totalQuestions}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            StreakCard(streak, isStreakActive)
        }
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun StreakCard(
    streak: Int,
    isActive: Boolean
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
        .background(
                color = if (isActive) Color(0xFFFFD700) else Color.Gray,
        shape = RoundedCornerShape(16.dp)
        )
        .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Streak",
            tint = if (isActive) Color.White else Color.DarkGray,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = streak.toString(),
            color = if (isActive) Color.White else Color.DarkGray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}