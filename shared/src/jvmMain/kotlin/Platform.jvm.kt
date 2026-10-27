package com.siiberad.minitask

class JVMPlatform : Platform {
    override val name: String = "JVM"
}

actual fun getPlatform(): Platform = JVMPlatform()