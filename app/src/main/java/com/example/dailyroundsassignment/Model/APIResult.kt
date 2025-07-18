package com.example.dailyroundsassignment.Model

sealed class APIResult<T> {
    data class Success<T>(val data: T): APIResult<T>()
    data class Error<T>(val error: String): APIResult<T>()
    class Loading<T> : APIResult<T>()
}