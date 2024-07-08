package com.vishnuraman.oop

import kotlin.jvm.Throws

object Exceptions {

    fun maybeString(): String? = null

    fun demoExceptions() {
        // code that might fail
        //val division = 42 / 0
        // throws NullPointerException
        val nullable: String? = maybeString() // from somewhere else
        val theString = nullable!!
    }

    // throwing an exception
    class Person private constructor(val name: String, val age: Int) {
        companion object {
            @Throws(IllegalArgumentException::class) // <- can specify exceptions thrown, just a hint
            fun create(name: String, age: Int): Person =
                if (age < 0) throw IllegalArgumentException("Age must not be negative!")
                else Person(name, age)
        }
    }

    fun demoCatch() {
        // catching exceptions
        val maybePerson: Person = try {
            Person.create("Vishnu", -10)
            // put the MOST SPECIFIC exceptions first
        } catch (e: IllegalArgumentException) {
            Person.create("Vishnu", 99)
        } catch (e: RuntimeException) {
            Person.create("Vishnu", 99)
        } finally {
            // runs no matter what
            // release of resources
            println("Something needds to be released no matter what")
        }

        val vishnu = maybePerson.age
        println(vishnu)
    }

    /*
        Throwable
            - Exception -> something wrong with the LOGIC, we can control
                - IOException, FileNotFoundException.... (checked exceptions) -> have to catch
                - RuntimeException (unchecked exceptions)
                    - NullPointerException, IllegalArgumentException\
                - in Kotlin, all exceptions are "unchecked"

            - Error -> something wrong the JVM
                - StackOverflowError
                - OutOfMemoryError
     */

    class MyException(val count: Int): RuntimeException("Something wrong") {
        // properties, methods
    }

    fun demoMyException() {
        throw MyException(4)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        demoCatch()

    }
}