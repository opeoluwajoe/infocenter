package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.detail.PostDetailScreen
import com.example.myapplication.ui.list.PostListScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.LIST,
        modifier = modifier,
    ) {
        composable(Routes.LIST) {
            PostListScreen(
                onPostClick = { postId ->
                    navController.navigate(Routes.detail(postId))
                },
            )
        }
        composable(
            route = Routes.DETAIL,
            arguments = listOf(
                navArgument("postId") { type = NavType.IntType },
            ),
        ) { backStackEntry ->
            PostDetailScreen(
                onBack = { navController.navigateUp() },
                viewModel = viewModel(backStackEntry),
            )
        }
    }
}
