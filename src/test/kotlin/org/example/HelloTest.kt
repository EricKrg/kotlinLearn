package org.example

import org.junit.Assert
import org.junit.Test
import java.lang.IllegalArgumentException
import java.util.*
import kotlin.test.assertEquals

class HelloTest {

}

class AgeCalc {

    fun getAge(dob: Calendar): Int {
        val today = Calendar.getInstance()
        if (dob.timeInMillis > today.timeInMillis) throw IllegalArgumentException()
        return today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
        // this is obs. just mocking
    }
}

class AgeCalcTest() {

    @Test
    fun checkAgeBornToday() {
        assertEquals(0, AgeCalc().getAge(Calendar.getInstance()))
    }

    @Test
    fun check1000daysAgo() {
        val date = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, -1000)

        assertEquals(3, AgeCalc().getAge(date));
    }

    @Test
    fun testForEx() {
        val date = Calendar.getInstance()
        date.add(Calendar.YEAR, 10)

        Assert.assertThrows(java.lang.IllegalArgumentException::class.java) {
            AgeCalc().getAge(date)
        }
    }
}