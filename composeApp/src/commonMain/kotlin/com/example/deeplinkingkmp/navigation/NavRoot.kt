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
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute

private const val DEEP_LINK_URI_PATTERN = "https://deep-link.com/item/"
private const val DETAIL_ARG = "{id}"

@Composable
fun NavRoot() {
    val navController = rememberNavController()
    DeepLinkListener(navController)

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
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(Route.Details(item))
                            }.padding(16.dp),
                        text = "Item: $item"
                    )
                }
            }
        }
        composable<Route.Details>(
            deepLinks = listOf(
                navDeepLink {
//                  navigation will substitute {id} with argument from the route (must be identical!)
                    this.uriPattern = "$DEEP_LINK_URI_PATTERN$DETAIL_ARG"
                },
            )
        ) { backStackEntry ->
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