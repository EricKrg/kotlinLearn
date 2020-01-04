package org.example

import java.math.BigDecimal
import kotlin.math.roundToInt
import kotlin.random.Random
import java.util.*
fun main() {
    // kotlin is strong typed and datatypes are inferred
    // object always have type even if not declared
    // there are no literals in kotlin!
    val aString = "Hi" // String
    val aDouble = 12.2 // Double
    println("my Double is a ${aDouble.javaClass}")
    println("my Double is a ${aDouble::class.qualifiedName}")

    val myInt = aDouble.roundToInt();
    println("my integer $myInt")

    val bigDec = BigDecimal(11)  // BigDecimal bigDec = new BigDecimal(11);

    // var/val cannot be used until assigned, compile error not runtime!
    val notNull: BigDecimal
    //notNull.add(BigDecimal(1))
    notNull = bigDec.abs()

    // CASTING
    var result: Any
    val random = Random.nextInt(3)

    result = if (random == 1) {
        BigDecimal(10)
    } else {
        "not one"
    }
    when (result) {
        is BigDecimal -> result = result.add(BigDecimal(10))
        is String -> result = result.toUpperCase()
    }

    println(result)

}
