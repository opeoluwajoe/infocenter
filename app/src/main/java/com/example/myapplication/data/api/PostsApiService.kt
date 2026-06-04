package com.example.myapplication.data.api

import com.example.myapplication.data.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id") id: Int): Post
}
