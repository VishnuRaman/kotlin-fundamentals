package com.vishnuraman.oop

object AccessModifiers {
    open class Person(open val name: String) {
        // protected = accessible inside this class AND all child types
        protected fun sayHi() = "Hi, I'm $name"

        // private properties and methods can only be accessed inside the body of this particular class
        private fun watchNetflix(): String = "I'm binge watching my favourite series."

        // no modifier = "public"
        // modifier "internal" -> property/method accessible inside the same compilation module
        // useful for libraries

    }

    class Kid(override val name: String) : Person(name) {
        fun greetPolitely(): String =
            sayHi() + "I would love to play!"
    }

    // complication
    class KidWithParents(override val name: String, val age: Int, val mom: Person, val dad: Person) : Person(name) {
        // sayHi is protected, so I should be able access it
        // ... only on THIS instance. Not on other instances

        fun everyoneIntroducesThemselves(): String =
            // "${this.sayHi()} Here are my parents! ${mom.sayHi()} ${dad.sayHi}"
            "${this.sayHi()} Here are my parents! ${mom.name} ${dad.name}"
    }

    // private constructor
    class MyService private constructor(url: String) {
        // comes with a companion object

        companion object {
            fun local(): MyService = MyService("127.0.0.1")
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val alice = Person("Alice")
        val bob = Person("Bob")
        val kid = KidWithParents("Denis", 5, alice, bob)

        // val myService = MyService("127.0.0.1") // cannot build directly
        val myService = MyService.local()
    }
}