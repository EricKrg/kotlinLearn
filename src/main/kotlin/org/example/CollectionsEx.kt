package org.example

import excercise1.Person

class CollectionsEx

fun main() {
    // people Arraylist is mutable but cannot be reassigned
    val people = ArrayList<Person>()
    people.add(Person(1,"Mr","Bingo","Bongo", null))
    people.add(Person(2,"Mrs","Ingrid","Bongo", null))
    people.add(Person(3,"Mr","Zim","Lo", null))
    people.add(Person(4,"Mrs","Bi","Bo", null))

    // immutable list
    // uses Kotlin interface to java collections
    val colors = listOf("Red", "Green", "Blue")
    println(colors::class.qualifiedName)

    // mutable list
    val days = mutableListOf("Mon", "Tue", "Wed")
    val pers = mutableListOf<Person>(people[1], people[2])
    for (p in pers) println(p)

    // maps and sets
    val months = setOf("Jan","Feb", "Sept")
    val webCol = mapOf("red" to "ff0000", "blue" to "00ff00")

    // arrays alwasy mutable and fixed size
    val intArray: IntArray = intArrayOf(1,2,3,4,5)
    intArray.set(1,895) // or
    intArray[3] = 44
    intArray.forEach { println(it) }
}