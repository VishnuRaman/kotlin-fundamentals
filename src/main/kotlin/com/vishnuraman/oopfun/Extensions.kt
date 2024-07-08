package com.vishnuraman.oopfun

object Extensions {

    // we can add NEW methods & properties to existing types
    // 3 * "Kotlin"
    // 3.multiply("Kotlin")
    /*
        Int {
            fun multiply(aString: String): String {...}
        }
     */
    fun Int.multiply(aString: String): String {
    //  ^^^^^^^^^^^^ extension method
        var result = ""
        for (i in 1..this)
            result += aString
        return result
    }

    // extension properties
    // use extension methods instead
    val Int.nDigits: Int       // extension property (cannot have a backing field)
        get() {
            var result = 0
            var theNumber = this
            while (theNumber != 0) {
                theNumber /= 10
                result ++
            }
            return result
        }

    // restriction: can be shadowed (hae the same signature) as a real method from the class
    // in this case the real method
    class Person(val name: String, private val favLang: String  = "Kotlin") {
        fun greet() = "Hi everyone, I am $name"
    }

    fun Person.greet() =
    //  ^^^^^^^ the "receiver" type
        "$name says: I HATE EVERYONE! ERRRR"

    /*
        compiler makes new synthetic function (hidden)
        fun greet($this: Person): String = ...
     */

    // restriction: In the impl of extension method, you can only access public properties/methods of `this`

    @JvmStatic
    fun main(args: Array<String>) {
        val kotlinx3 = 3.multiply("Kotlin")

        println(kotlinx3)
        println(123456.nDigits)

        val obiwan = Person("Obiwan")
        println(obiwan.greet())

    }
}