package com.example.myapplication.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repository.PostsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostDetailViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val repository = PostsRepository()

    private val postId: Int = checkNotNull(savedStateHandle.get<Int>("postId")) {
        "postId is required"
    }

    private val _uiState = MutableStateFlow<PostDetailUiState>(PostDetailUiState.Loading)
    val uiState: StateFlow<PostDetailUiState> = _uiState.asStateFlow()

    init {
        loadPost()
    }

    fun loadPost() {
        viewModelScope.launch {
            _uiState.value = PostDetailUiState.Loading
            try {
                val post = repository.getPost(postId)
                _uiState.value = PostDetailUiState.Success(post)
            } catch (e: Exception) {
                _uiState.value = PostDetailUiState.Error(
                    e.message ?: "Failed to load post",
                )
            }
        }
    }
}
