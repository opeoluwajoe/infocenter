package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class Post(
    val id: Int,
    @SerializedName("userId") val userId: Int,
    val title: String,
    val body: String,
)
