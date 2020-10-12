package excercise1

import exercise2.Seat
import java.math.BigDecimal

interface Bookings {
    // requires all implementations of Bookings to have a get method for version
    val version: String

    fun isSeatFree(seat: Seat): Boolean

    fun reserveSeat(seat: Seat, customerID: Long): Boolean

    fun systemStatus(): String = "All is fine"

}

// all classes are final by default and need to be expl. opened
open class BookingManager(authKey: String) : Bookings {

    init {
        if (authKey != "1234") {
            throw UnAuthUser()
        }
    }

    override val version: String
        get() = "1.0"

    override fun isSeatFree(seat: Seat): Boolean {
        return true
    }

    override fun reserveSeat(seat: Seat, customerID: Long): Boolean {
        return true;
    }

}

// colon is uni. for extending or implementing a class/ interfacesuper.printStackTrace()
open class AdvancedBookingManager : BookingManager("1234") {
    override val version: String
        get() = "2.0"

    fun bulkBookings(seats: ArrayList<Seat>): Boolean {
        // do something special
        return true
    }
}

// implementing and inherting
class SuperAdvancedMBookingManager : AdvancedBookingManager(), java.io.Closeable {
    override fun close() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

// Throwables, custom ex.
class UnAuthUser : Throwable() {
    override val message: String?
        get() = "You are a fucking idiot!".toStupidCase()

    override fun printStackTrace() {
        super.printStackTrace()
        println(this.message)
    }
}

// Extensionsfunctions Example
// extending the standard String class
fun String.toStupidCase(): String {
    var res: String = ""
    this.split(" ").forEach {
        res += it[0].toLowerCase() + it.substring(1).toUpperCase() + " "
    }
    return res
}


fun main() {
    println(AdvancedBookingManager().isSeatFree(Seat(1, 1, BigDecimal(2), "cool")))

    // adding funs to existing classes --> Extension functions, String class is exented (even without being an open class)
    println("Hello dear Sir".toStupidCase())
}