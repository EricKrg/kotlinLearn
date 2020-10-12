package org.example

import java.lang.IllegalArgumentException

/**
 * Example on Java interop
 */

// cant call this in a java class
fun fancyTopLvlFun(num: Int, num2: Int): Int = num + num

data class Customer (val id: Long, val name: String)


class CustomerDB() {
    val customers = listOf<Customer>(
        Customer(1,"Matt"),
        Customer(2,"Jon"),
        Customer(3,"Louise")
    )

    @Throws(IllegalAccessException::class) // needs to be added only if used with normal java
    fun addCustomer(c: Customer) {
        fancyTopLvlFun(1,1)
        throw IllegalAccessException("You can not to this!")
    }

    // static fun
    companion object {
        fun helloWorld() = print("Hello World")

        @JvmStatic
        fun helloPluto() = print("Hello Pluto")
    }
}