package com.example.myapplication.ui.navigation

object Routes {
    const val LIST = "list"
    const val DETAIL = "detail/{postId}"

    fun detail(postId: Int) = "detail/$postId"
}
