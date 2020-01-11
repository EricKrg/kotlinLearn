package org.example

class ObjectEquality (val maybeNull: Int?) {
    // Elvis operator
    val safeReturn: Int
        get() = maybeNull ?: -1
       // maybeNull !== null ? maybeNull : -1

    // the let function
    fun getLastLetter(text: String ): String = text.takeLast(1)

    var favColor: String? = null

    fun getLastLetterOfFavColor(): String {
        return this.favColor?.let { this.getLastLetter(it) } ?: ""
        // { it.fun() } == { x -> x.fun() }
        /*if (this.favColor !== null) {
            return  this.let { this.getLastLetter(it) }
        } else {
            return ""
        }*/
    }

    // when statement
    fun colorType(c: String): String {
        /*return if (c == "") {
            "empty"
        } else if (c == "RED" || c == "BLUE" || c == "GREEN") {
            "RGB"
        } else {
            "other"
        }*/
        return when(c) {
            "" -> "empty"
            "RED", "GREEN", "BLUE" -> "rgb"
            else -> "other"
        }
    }

}

// why the binary Operator for equals ?? --> in Kotlin '==' tests for value Equality, for reference eq. '==='
// JAVA object1 == object2 -> ref. eq; object1.equals(object2) -> value eq.
// Kotlin obj1 === obj2 -> ref. eq; obj1 == obj2 -> value eq.
fun yN(name : String): String = if ("Jim" == name) "yes" else "no"

fun main() {
    val name = "Tom"
    val age = 20
    val old = if (age > 80) true else false
    println(yN(name))
}