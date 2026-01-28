package com.example.deeplinkingkmp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavRoot(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.List
    ){
        composable<Route.List> {  }
        composable<Route.Details> {  }
    }
}