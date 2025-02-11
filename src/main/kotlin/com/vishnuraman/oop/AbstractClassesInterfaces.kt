package com.vishnuraman.oop

object AbstractClassesInterfaces {

    open class Animal

    // abstract classes/properties/methods are automatically open
    abstract class Plant(scientificName: String) { // class with possibly abstract properties and/or methods
        abstract val maxHeight: Int // property with no value
        abstract fun grow(): String // method signature with no impl
        // can define "regular" properties/methods
        val growthMechanism: String = "photosynthesis"
    }

    //val myPlant = Plant("rosa") // abstract classes cannot be instantiated*

    class Strawberry : Plant("fragaria") {
        // implement ALL abstract properties/methods
        override fun grow(): String = "nice tasty strawberries"
        override val maxHeight: Int = 100
    }

    // interfaces = ultimate abstract types
    interface Carnivore { // may not have constructor arguments
        // can define properties/methods without abstract keywords - automatically abstract & open
        fun eat(animal: Animal): String
        val preferredMeal: String
            // may only provide impl if the porperty has no backing field, and with get()/set() only
        // can provide concrete/methods = "default" implementations
    }

    interface Herbivore {
        fun eat(plant: Plant): String
    }

    // inheritance model in Kotlin: extend ONE class, but maybe multiple interfaces
    class Crocodile() : Animal(), Carnivore {
        //                ^^^^^^^^ if you inherit from class + interface(s), then the first thing you need to specify is the class
        override val preferredMeal: String = "gazelle"
        override fun eat(animal: Animal): String =
            "crunching this poor thing in one bite"
    }

    class Human: Carnivore, Herbivore {
        override val preferredMeal: String = "sugar"
        override fun eat(animal: Animal): String = "hopefully this makes a good steak"
        override fun eat(plant: Plant): String = "eating this plant"
    }

    // an interface can extend another interface
    interface Omnivore: Carnivore, Herbivore
    // a class can extend just an interface
    abstract class Human_v2: Omnivore
    // what id 2 interfaces have the same method

    interface Instrument {
        fun play(): String
    }

    interface Game {
        fun play(): String
    }

    class GuitarApp: Instrument, Game {
        override fun play(): String = "both instrument and a game"
    }

    @JvmStatic
    fun main(args: Array<String>) {

    }
}