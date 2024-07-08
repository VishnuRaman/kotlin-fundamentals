package com.vishnuraman.oopfun

object DataClasses {

    // hashCode, toString, equals
    class CityNaive(val name: String, val country: String, val population: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as CityNaive

            if (name != other.name) return false
            if (country != other.country) return false
            if (population != other.population) return false

            return true
        }

        override fun hashCode(): Int {
            var result = name.hashCode()
            result = 31 * result + country.hashCode()
            result = 31 * result + population
            return result
        }

        override fun toString(): String =
            "City($name, $country, $population)"
    }

    // data class - The choice for storing "information" as classes
    // all the above automatically!
    // equals, hashCode, toString - made by the compiler!
    // copy
    // destructuring - componentN functions made by the compiler
    // restriction: all the constructor args MUST be properties -> vals or vars
    // restriction: must have at least one property
    // restriction: cannot inherit a data class
    data class City(val name: String, val country: String, val population: Int) {
        // new properties, methods, ...
    }

    // meant to be passed around and stored
    // regular classes are usually resources, contain functionalities -> services, managers, sockets, connections, file handlers

    data object NoOperation

    // sealed interfaces
    // gaming

    sealed interface Message
    data class Join(val player: String) : Message
    data class Ping(val from: String, val to: String) : Message
    data class Exit(val player: String) : Message
    data object TerminateGame: Message


    @JvmStatic
    fun main(args: Array<String>) {
        val london = City("london", "UK", 9000000)
        val london2 =  City("london", "UK", 9000000)

        val grownLondon = london.copy(population = 10000000)
        println(london == london2)
        println(london) // london.toString()
        println(grownLondon)

        // destructuring
        /*
            val name = bucharest.component1()
            val country = bucharest.component2()
            val pop = bucharest.component3()
         */
        val (name, country, population) = london
    }
}