package org.example

import java.io.FileInputStream
import java.lang.ArithmeticException

@Throws (InterruptedException::class)
fun dived(a: Int, b: Int): Double {
    Thread.sleep(1000)
    return a.toDouble() / b
}

fun printFile() {
    val input = FileInputStream("file.txt")
    input.use {
        // if an ex. occurs here, the obj. will be closed safely
    }
}

// all excpetions are unchecked, in favor of functional programming
fun main() {
    // unchecked interrupted ex
    Thread.sleep(100)
    try {
        val i = 7/0
    } catch (e: ArithmeticException) {
        println("division by zero, pleb")
    }

    dived(2,3)

    // try as an expression
    val result = try {
        dived(2, 5)
    } catch (e: Exception) {
        -1
    }
    println(result)

    // try with resources
    // ensure resources to be closed

}