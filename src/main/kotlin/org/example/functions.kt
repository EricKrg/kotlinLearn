package org.example

fun main() {
    printString("Boo!")
    println(addTwo(1.0,1.4))
    // named params
    someMath(1.2,2.4)
    someMath(second = 2.4, first = 1.2)
    // optional
    println(addOpt())
    println(addOpt(1.0))
    println(addOpt(2.3, 20.0))
    println(addOpt(second = 1.0))

    // lambda
    takeAnotherLambda("1") { i -> i.toInt()}
}

// toplvl fun (public static by default), usable package wide
// params of a fun are immutable
fun printString(param: String){
    println(param)
}
// only usable in this file, private static..
private fun printAnotherString(param: String){
    println(param)
}
// void == unit not need to declare
// unit is a object, it is not null, if returned no nullPointer possible
fun name (para: String): Unit {
    return
}

// SINGLE Expression funs
fun addTwo(one: Double, two: Double): Double = one + two

// NAMED Params
fun someMath(first: Double, second: Double) {
    println("Result is ${first - second}")
}

// overloaded and optional
fun addOpt(first: Double = 0.6,
           second: Double = 0.3): Double = first + second


// LAMBDA

// not really kotlin
fun takeALambda(input: String, action: java.util.function.Function<String,Int>) {
    println(action.apply(input))
}
// kotlin way

fun takeAnotherLambda(input: String, action: (String) -> Int) {
    println(action(input))
}