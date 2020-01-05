package excercise1

import java.util.*

data class Person(private val id: Long,
                  private val title: String,
                  private val firstName: String,
                  private val surname: String,
                  private val dateOfBirth: Calendar?) {

    override fun toString(): String = "$title $firstName $surname"

    override fun hashCode(): Int = Objects.hash(this.id, this.title, this.firstName, this.surname)

    override fun equals(other: Any?): Boolean {
        return when(other) {
            is Person -> this.id == other.id
            else -> false
        }
    }

    fun getAge(): Int {
        return getAge(this.dateOfBirth)
    }

    companion object {
        fun getAge(cal: Calendar?): Int {
            return when(cal) {
                is Calendar -> {
                    val today = GregorianCalendar()
                    val res: Int = if (cal.get(Calendar.YEAR) >= today.get(Calendar.YEAR)) -1
                    else today.get(Calendar.YEAR) - cal.get(Calendar.YEAR)
                    res
                }
                else -> -1
            }
        }
    }
}

fun main() {
    val person = Person(1L, "Dr", "Jo", "Bo", GregorianCalendar(2010,9,3))
    val person2 = Person(2L, "Dr", "Jo", "Bo", null)
    println(person)
    println(person.equals(null))
    println(person.equals(person2))
    println(person.getAge())
    println(person2.getAge())
}