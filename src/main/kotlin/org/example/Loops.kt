package org.example

import excercise1.Person

class Loops()

fun main() {
    var x: Int = 0
    while (x < 10) {
        x++
        println(x)
    }
    // for loop

    val people = ArrayList<Person>()
    people.add(Person(1,"Mr","Bingo","Bongo", null))
    people.add(Person(2,"Mrs","Ingrid","Bongo", null))
    people.add(Person(3,"Mr","Zim","Lo", null))
    people.add(Person(4,"Mrs","Bi","Bo", null))

    for (p in people) {
        println(p)
    }
    // destructuring in for loop
    for ( (id, title, firstName, surname) in people ) {
        println("$firstName $surname")
    }

    val peopleMap = HashMap<Int,Person>()
    peopleMap[1] = Person(1,"Mr","Bingo","Bongo", null)
    peopleMap[2] = Person(2,"Mrs","Ingrid","Bongo", null)
    peopleMap[3] = Person(3,"Mr","Zim","Lo", null)
    peopleMap[4] = Person(4,"Mrs","Bi","Bo", null)

    for ( (key, value) in peopleMap) {
        println("$key $value")
    }

    // range Loop
    val myRange = 0..9
    for(i in myRange) {
        println(i)
    }

    (0..100).forEach { i -> println(i)}
    (0..100).forEach { println(it)}

    (10 downTo 4).forEach { println(it) }
    (100 downTo 40 step 10).forEach { println(it) }
}

