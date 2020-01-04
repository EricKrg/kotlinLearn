package org.example

// fun as toplevel obj
fun main() {
    System.out.println("hi")
    println("hi in kotlin")

    // kotlin prefers to use val instead of var
    // it is prefered to use immutable over mutable datatypes
    var name: String = "Eric"
    val surname: String = "Cool"
    println("Hello $name $surname")
    println("Hello $name your last name is ${surname.length} chars long")

    val longString = """|blbl akblasbl
                        |bla blba nlablbab blabl balbe
                        |bla blum""".trimIndent().trimMargin("|")
    println(longString)
    println(longString.replaceAfterLast("bla", "zzzz"))
}