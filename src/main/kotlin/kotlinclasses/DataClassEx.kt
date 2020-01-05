package kotlinclasses

// auto creates toString, hashCode, deep-copy, compare ...
data class DataClassEx(val name: String, val size: Int, val choice: Boolean) {

}

fun main() {
    val dataClassEx = DataClassEx("test", 12, true)
    println(dataClassEx)
    val data2 = dataClassEx.copy(choice = false)
    println(data2)

    // destructing class fields --> default in dataclasses
    val (name, size, choice) = data2
    println("$name $size $choice")
}