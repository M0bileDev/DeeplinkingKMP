package com.example.deeplinkingkmp.navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object List : Route

    @Serializable
    data class Details(val id: Int) : Route
}