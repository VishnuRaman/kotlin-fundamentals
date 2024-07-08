package com.vishnuraman.basics

fun simpleFunction(arg: String) {
    println("Hello, $arg") // string template or string interpolation
}

fun printHello() {
    println("Hello")
}

// function that concatenates count times
//concatenateString("Kotlin", 3) -> KotlinKotlinKotlin
fun concatenateString(aString: String, count: Int): String =
    if (count <= 0) ""
    else (1..count).toList().fold(""){ sum, _ -> sum + aString }


//recursion
fun concatenateStringRec(aString: String, count: Int): String =
    if (count <= 0) ""
    else aString + concatenateString(aString, count - 1)

// special syntax for simple-expr functions
fun combineStrings(aString1: String, aString2: String): String =
    "$aString1---$aString2"

// default args
fun demoDefaultArg(regularArg: String = "Kotlin", intArg: Int = 0): String =
    "$regularArg---$intArg"

// nested function calls
fun complexFunction(someArg: String) {
    // very complex code
    fun innerFunction(innerArg: Int) {
        println("inner arg = $innerArg")
    }

    innerFunction(45)
}

/**
 * Exercises:
 * 1. a greeting function (name, age) => "Hi, my name is  __ and I am __ years old."
 * 2. a factorial function n => 1 * 2 * 3 * ... * n
 * 3. a fibonacci function n => nth Fibonacci Number
 *  1,2,3,5,8,13,21
*  4. a function that tests whether a number is prime n => boolean whether that n is prime
 *  isPrime(8) = false
 */

// 1
fun greet(name: String, age: Int): String =
    "Hi, my name is $name and I am $age years old"


// 2
fun factorial(n: Int): Long {
    if (n <= 0 ) return 0

    var product = 1L
    for (i in 1..n) product *= i

    return product
}

// 2
fun factorialRec(n: Int): Long =
    if (n <= 0) 0
    else if (n == 1) 1
    else n * factorialRec(n - 1)

// 3
fun fibonacci(n: Int): Long {
    var smaller = 1L
    var larger = 2L

    if (n <= 0 ) return -1
    if (n ==1) return 1
    if (n == 2) return 2

    // 1  2 3 5 8 13 21
    for (i in 3..n) {
        val next  = smaller + larger
        smaller  = larger
        larger  = next
    }

    return larger
}

// 3
fun fibonacciRec(n: Int): Long =
    if (n <= 0) -1
    else if (n == 1) 1
    else if (n == 2) 2
    else fibonacciRec(n-1) + fibonacciRec(n-2)

// 4
fun testPrime(n: Int): Boolean {
    // 1 < d < n, n % d == 0 => n is NOT a prime
    for (d in 2.. n/2)
        if (n % d == 0) return false


    return true
}

// 4
// no stack frames to allocate
tailrec fun testPrimeRec(n: Int, d : Int = 2): Boolean =
    if (n % d == 0) false
    else if (d > n/2) true
    else testPrimeRec(n, d+1) // recursive call is computed LAST on this branch
//       ^ tail position == TAIL RECURSIVE


fun main(args: Array<String>) {
    simpleFunction("Vishnu")
    printHello()
    println(concatenateString("Kotlin", 4))

    val normalCall = demoDefaultArg("Normal Call", 32)
    val defaultCall = demoDefaultArg("Default Call")
    val multiCall = demoDefaultArg()
    val secondNormalCall = demoDefaultArg(intArg = 32)

    // exercises
    println(greet("Vishnu", 13))
    println(factorial(5))

    // 3
    println("fibo iterative")
    for (i in 1..10) {
        println(fibonacci(i))
    }

    println("fibo recursive")
    for(i in 1..10) {
        println(fibonacciRec(i))
    }

    // 4

    println("prime test")
    println("81 - ${testPrime(81)}")
    println("7 - ${testPrime(7)}")
    println("2003 - ${testPrime(2003)}")

    println("prime test rec")
    println("81 - ${testPrimeRec(81)}")
    println("7 - ${testPrimeRec(7)}")
    println("2003 - ${testPrimeRec(2003)}")
}