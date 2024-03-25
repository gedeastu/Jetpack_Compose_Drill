package com.example.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun RootNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, route = "root", startDestination = "home-screen"){
        composable(route = "home-screen"){
            Navigation(navController = navController)
        }
        composable(route = "about"){
            AboutScreen(navController = navController)
        }
    }
}