package com.example.dailyroundsassignment.Network

import com.example.dailyroundsassignment.QuizRepository.QuizRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): QuizApiService = RetrofitClient.apiService

    @Provides
    @Singleton
    fun provideQuizRepository(apiService: QuizApiService): QuizRepository {
        return QuizRepository(apiService)
    }
}