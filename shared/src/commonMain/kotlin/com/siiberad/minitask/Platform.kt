package com.siiberad.minitask

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform