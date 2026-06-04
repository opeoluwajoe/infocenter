package com.example.myapplication.data.repository

import com.example.myapplication.data.NetworkModule
import com.example.myapplication.data.api.PostsApiService
import com.example.myapplication.data.model.Post

class PostsRepository(
    private val api: PostsApiService = NetworkModule.postsApiService,
) {
    suspend fun getPosts(): List<Post> = api.getPosts()

    suspend fun getPost(id: Int): Post = api.getPost(id)
}
