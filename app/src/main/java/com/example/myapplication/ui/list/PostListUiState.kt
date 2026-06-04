package com.example.myapplication.ui.list

import com.example.myapplication.data.model.Post

sealed interface PostListUiState {
    data object Loading : PostListUiState
    data class Success(val posts: List<Post>) : PostListUiState
    data class Error(val message: String) : PostListUiState
}
