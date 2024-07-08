package com.vishnuraman.oop

object Inheritance {

    open class Animal { //  open -> class can be inherited
        open fun eat() { // can be overridden in child classes -> if you want to override need to mark as open
            println("I am eating")
        }
    }

    class Dog : Animal() {
        // Dog "extends"/inherits from Animal
        // Dog is a subtype of Animal, or Animal is the supertype of Dog
        // Dog is an Animal

        // method eat is available

        // override  = change the behaviour of the eat() method
        override fun eat() {
            // super.eat() -> calls the eat() method from parent class
            println("I am eating as a dog")
        }

    }

    val lassie = Dog()

    val anAnimal: Animal = Dog() // subtype polymorphism

    // restrictions - need to provide constructor for parent class
    open class Person(open val name: String, open val age: Int)
    class Adult(override val name: String, override val age: Int) : Person(name, age)

    // restrict inheritance with the 'final' keyword
    class Travel(val destination: String) {
        final fun confirm(): String = "Congrats! You are going to $destination"
        // final  = cannot be overridden
    }

    open class Leisure {
        open fun confirmExperience(): String = "Chill"
    }

    open class Travel_v2(destination: String) : Leisure() {
        final override fun confirmExperience(): String =
            ""
    }

    class SpecialTickets : Travel_v2("USA") {
//        override fun confirmExperience(): String =
//            "Seeing Breaking Benjamin"
        // overriding stopped at Travel_v2
    }

    // sealing a type hierarchy = restricts inheritance to THIS FILE ONLY
    sealed class ProtocolMessage(contents: String) // automatically open
    class BeginningExchange(flag: String, contents: String) : ProtocolMessage(contents)
    class Exchange(sender: String, receiver: String, contents: String) : ProtocolMessage(contents)
    object EndExchange : ProtocolMessage("End")
    // no other subtypes of ProtocolMessage may exist outside this file

    /*
    Any -> parent of all possible types you create  - subtype of Any?
    ^
    Animal -> Animal?
    ^
    Dog -> Dog?
    ^
    Nothing -> child of all types
     */

    val nothing: Nothing = throw RuntimeException("Nothing")


    @JvmStatic
    fun main(args: Array<String>) {
        lassie.eat()
        anAnimal.eat()
    }
}