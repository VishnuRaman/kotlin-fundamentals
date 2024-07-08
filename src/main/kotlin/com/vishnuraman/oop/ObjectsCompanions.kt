package com.vishnuraman.oop

// object in Kotlin = definition of a type + the only instance of that type
// Singleton pattern = single e.g. service, connection, data source, state

object MySingleton {
// type + the only instance of this type
    val aProperty = 42
    fun aMethod(arg: Int) : Int {
        println("Hellot from singleton $arg")
        return aProperty + arg
    }

    // define entry points to your Kotlin application
    // public static void main(String[] args) == equivalent java syntax

    @JvmStatic
    fun main(args: Array<String>) {
        println("Singleton entry point")
    }

}

object ObjectsCompanions {
    // companion objects

    class Guitar(val nStrings: Int, val type: String) {
        // properties
        // methods
        fun play() {
            println("$type guitat with $nStrings strings playing!")
        }

        companion object {
            // properties specific to the type itself rather than the instance of the class = "static"
            val HAS_STRINGS = true
            fun createSimpleGuitar(type: String) : Guitar = Guitar(6, type)

        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val gibson = Guitar(6, "electric")
        gibson.play()
        val guitarHaveStrings = Guitar.HAS_STRINGS

        val simpleGuitar = Guitar.createSimpleGuitar("acoustic")
    }
}

fun main(args: Array<String>) {
    val theSingleton = MySingleton
    val anotherSingleton = MySingleton

    val singletonProperty = MySingleton.aProperty

    println(theSingleton == anotherSingleton)

    val result = MySingleton.aMethod(89)
    println("Result of a singleton method: $result")
}