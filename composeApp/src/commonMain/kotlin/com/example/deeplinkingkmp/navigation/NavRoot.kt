package com.example.deeplinkingkmp.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun NavRoot() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.List
    ) {
        composable<Route.List> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(100) { item ->
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(16.dp).clickable {
                            navController.navigate(Route.Details(item))
                        },
                        text = "Item: $item"
                    )
                }
            }
        }
        composable<Route.Details> { backStackEntry ->
            val route = backStackEntry.toRoute<Route.Details>()
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Item: ${route.id}"
                )
            }
        }
    }
}