package com.example.myapplication.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repository.PostsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostListViewModel(
    private val repository: PostsRepository = PostsRepository(),
) : ViewModel() {

    private val _uiState = MutableStateFlow<PostListUiState>(PostListUiState.Loading)
    val uiState: StateFlow<PostListUiState> = _uiState.asStateFlow()

    init {
        loadPosts()
    }

    fun loadPosts() {
        viewModelScope.launch {
            _uiState.value = PostListUiState.Loading
            try {
                val posts = repository.getPosts()
                _uiState.value = PostListUiState.Success(posts)
            } catch (e: Exception) {
                _uiState.value = PostListUiState.Error(
                    e.message ?: "Failed to load posts",
                )
            }
        }
    }
}
