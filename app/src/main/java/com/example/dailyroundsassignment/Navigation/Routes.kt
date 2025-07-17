package com.example.dailyroundsassignment.Navigation

sealed class Routes(val route: String) {
    object Questions: Routes("Questions")
    object Result: Routes("Result")
    object Loading: Routes("Loading")
}