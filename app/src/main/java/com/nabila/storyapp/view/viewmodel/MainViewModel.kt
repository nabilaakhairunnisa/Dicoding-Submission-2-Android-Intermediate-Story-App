package com.nabila.storyapp.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nabila.storyapp.data.model.UserModel
import com.nabila.storyapp.data.repository.StoryRepository
import com.nabila.storyapp.data.response.ListStoryItem
import kotlinx.coroutines.launch
import java.io.File

class MainViewModel(private val repository: StoryRepository) : ViewModel() {

    val detail = repository.detail

    val storiesWithLocation = repository.storiesWithLocation

    fun register(name: String, email: String, password: String) = repository.register(name, email, password)

    fun login(email: String, password: String) = repository.login(email, password)

    fun getStories(token: String): LiveData<PagingData<ListStoryItem>> = repository.getStories(token).cachedIn(viewModelScope)

    fun getDetailStory(token: String, id: String) = repository.getDetailStory(token, id)

    fun uploadImage(token: String, file: File, description: String) = repository.uploadImage(token, file, description)

    fun getStoriesWithLocation(token: String) = repository.getStoriesWithLocation(token)

    fun saveSession(user: UserModel) {
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }

    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
}