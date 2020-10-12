package kotlinclasses

// classes are public by default
class Customer {
    val name: String
    var address: String
    var age: Int

    constructor (name: String, address: String, age: Int) {
        this.name = name
        this.address = address
        this.age = age
    }
}
// kotlin shorthand with default constructor
// getter and Setters not needed
class CustomerKotlin(val name: String,
                     private var address: String,
                     private var age: Int) {
    //secondary constructor
    constructor(name: String, age: Int): this(name,"",age) {

    }
    // run when ever the primary constructor is called
    init {
        println("init ${this.javaClass}")
    }
    // class method
    fun nameUpper(): String = this.name.toUpperCase()
    // overriding functions
    override fun toString(): String = "${this.nameUpper()}  $age $address"

    // static class method, prob. a thing you will the very seldom bc of top-lvl funs
    companion object {
        fun getInstance() = CustomerKotlin("Ina", "Way 98", 45)
    }

}

class AlternativeCustomer(val name: String, val age: Int) {
    var address: String

    init {
        address = ""
    }
    constructor(name: String, age: Int, address: String): this(name, age) {
        this.address = address

    }
    operator fun component1() = this.name
    operator fun component2() = this.age

}

class DefaultCustomer (val name: String, val address: String = "", var age: Int) {
    // overriding getter and setter
    var approved: Boolean = false
    set(value) {
        if(age > 17) {
            field = value
        } else {
            println("Too young to be approved")
        }
    }
    // dummy variable
    val nextAge
    get() = this.age + 1

}

fun main() {
    val customer = Customer("Eric", "Street 10", 22)
    val kCustomer = CustomerKotlin("Tim", 22)
    val kCustomer2 = CustomerKotlin("Tom", "Road 2", 99)
    val kCustomer3 = DefaultCustomer("Tom", "Road 2", 9)
    println(customer.name)
    println(kCustomer.nameUpper())
    println(kCustomer2)
    kCustomer3.approved = true
    println(kCustomer3.approved)
    println(kCustomer3.nextAge)

    // static
    val staticCustom = CustomerKotlin.getInstance()
    // destructing in normal classes
    val altCust = AlternativeCustomer("Tom",  2, "Road 9")
    val (name, age)  = altCust
    println("$name $age")
}
