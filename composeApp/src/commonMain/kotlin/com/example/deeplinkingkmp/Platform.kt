package com.example.deeplinkingkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform