package exercise2

import java.math.BigDecimal

data class Seat(val row: Int, val num: Int, val price: BigDecimal, val description: String) {
    //YOU MAY NOT EDIT THIS CLASS!
    override fun toString(): String = "Seat $row-$num $$price ($description)"
}

class Theater {

    // SEAT PRICES:
    // Seats in rows 14 and 15 cost 14.50
    // Seats in rows 1 to 13 and numbered 1 to 3 or 34 to 36 cost 16.50
    // All other seats in row 1 cost 21.00
    // All other seats cost 18.00

    // SEAT DESCRIPTIONS:
    // Seats in row 15: "Back row"
    // Seats in row 14: "Cheaper seat"
    // All other rows, seats 1 to 3 and 34 to 36: "Restricted View"
    // All other seats in rows 1 and 2 "Best view"
    // All other seats: "Standard seat"
    val rows = 1..15
    val seatsRow = 36
    val restricted1 = 1..3
    val restricted2 = 34..36
    val front = 1..2
    val seats
    get() = this.hiddenseats;
    private val hiddenseats = mutableListOf<Seat>()
    init {
        val seatsCreation = arrayListOf<Seat>()
        var seat: Seat
        var price: BigDecimal
        var desc: String

        fun getPrice(row: Int, num: Int): BigDecimal {
            return when {
                row > 13 -> BigDecimal(14.5)
                row in front -> BigDecimal(21)
                num in restricted1 || num in restricted2 -> BigDecimal(16.5)
                else -> BigDecimal(18)
            }
        }

        fun getDesc(row: Int, num: Int): String {
            return when {
                row == 14 -> "cheap"
                row == 15 -> "back row"
                row in front -> "Best"
                num in restricted1 || num in restricted2 -> "restricted"
                else -> "Standard"
            }
        }

        for (i in rows) {
            (1..seatsRow).forEach {
                hiddenseats.add(Seat(i, it, getPrice(i,it), getDesc(i,it)))
            }
        }
    }

}

fun main(args: Array<String>) {
    val cheapSeats = Theater().seats.filter { it.price == BigDecimal(14.50)}
    for (seat in cheapSeats) println (seat)
}
