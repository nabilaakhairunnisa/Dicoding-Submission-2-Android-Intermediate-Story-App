package com.nabila.storyapp.data.di

import android.content.Context
import com.nabila.storyapp.data.api.ApiConfig
import com.nabila.storyapp.data.preference.UserPreference
import com.nabila.storyapp.data.preference.dataStore
import com.nabila.storyapp.data.repository.StoryRepository

object Injection {
    fun provideRepository(context: Context): StoryRepository {
        val apiService = ApiConfig.getApiService()
        val pref = UserPreference.getInstance(context.dataStore)
        return StoryRepository.getInstance(apiService, pref)
    }
}
