package com.example.myapplication.ui.detail

import com.example.myapplication.data.model.Post

sealed interface PostDetailUiState {
    data object Loading : PostDetailUiState
    data class Success(val post: Post) : PostDetailUiState
    data class Error(val message: String) : PostDetailUiState
}
