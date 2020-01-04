package org.example

import java.lang.IllegalArgumentException

fun main() {
    // No nullPointers anymore ?
    //var name: String = null; // not allowed safeguard
    var name: String? = null // optional nullable
    //name.toUpperCase() // not allowed bc nullPointer possible

    /*name = "Eric"
    name.toUpperCase()*/

    // not very kotlin
    if (name !=  null) {
        name.toUpperCase()
    }
    // kotlin like with the null-Safe operator
    println(name?.toUpperCase())
    name = "Tim"
    println(name?.toUpperCase())
    // only assing nullable if value actually can be null,
    // otherwise break already when compiling

    // NON NULL Assertion
    /*name = null
    name!!.toUpperCase()*/

    var myInt = 7
    //myInt = null
    var nullInt: Int? = 8
    nullInt = null

    // NOTHING TYPE
    //https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing.html
    checkAge(18)
    checkAge(-1)


}

fun failWithWrongAge(age: Int?): Nothing {
    throw IllegalArgumentException("Wrong age: $age")
}

fun checkAge(age: Int?) {
    if (age == null || age !in 0..150) failWithWrongAge(age)
    println("Congrats! Next year you'll be ${age + 1}.")
}
