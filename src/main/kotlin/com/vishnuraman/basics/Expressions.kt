package com.vishnuraman.basics

fun main(args: Array<String>) {

    // expressions = structures that are turned into values
    val meaningOfLife = 40 + 2

    // math expression: operand and operators +,-,/,%
    val mathExpression = 2 + 3 * 4

    // bitwise operators: shr, shl, ushr, and, or, xor, inv
    val bitwiseExpression = 2 shl 2 // 1000

    // comparison expression: == (equal), != (not equal), <, <=, >, >=, ===  (two values refer to same instance in memory), !==
    val equalityTest = 1 == 2 // false

    // boolean expressions ! (not), && (and), || (or)
    val nonEqualityTest = !equalityTest

    // instructions and expressions
    // expressions are EVALUATED to a value - functional programming
    // instructions are EXECUTED - imperative programming

    // if structure
    val aCondition = 1 >2
    if (aCondition) println("true")
    else println("false")

    val anIfExpression = if (aCondition) 42 else 999 // if EXPRESSION

    println(anIfExpression)
    println(if (aCondition) 42 else 999)

    // when - "switch on steroids"
    when(meaningOfLife) {
        42 -> println("the meaning of life from HGG")
        43 -> println("not the meaning of life from HGG")
        else -> println("anything else")
    }

    // when EXPRESSION
    val meaningOfLifeMessage = when (meaningOfLife) {
        42 -> "the meaning of life from HGG"
        43 -> "not the meaning of life from HGG"
        else -> "anything else"
    }

    // a branch in when with multiple values
    val meaningOfLifeMessage_v2 = when (meaningOfLife) {
        42, 43 -> "the meaning of life from HGG or close enough"
        else -> "anything else"
    }

    // branches can be arbitrary expressions
    val meaningOfLifeMessage_v3 = when (meaningOfLife) {
        40 + 2 -> "the meaning of life from HGG, computed"
        else -> "anything else"
    }

    // conditions in branches
    /*
    if (mol < 42) {...}
    else if (mol > 100) {...}
    else {...}
     */
    val meaningOfLifeMessage_v4 = when {
        meaningOfLife < 42 -> "meaning of life is too small"
        meaningOfLife > 100 -> "meaning of life is too large"
        else -> "close enough"
    }

    // test for types in a when clause
    val something: Any = 42
    val someExpression = when(something) {
        is Int -> "It is an integer, maybe the meaning of life!"
        is String -> "It is a string, so maybe not the meaning of life"
        else -> "not sure what type this can be"
    }

    // loops - instructions
    // for loops
    println("inclusive range")
    for (i in 1 .. 10) {
        println("doing something")
        println(i)
    }

    println("exclusive range")
    for (i in 1 ..< 10) println(i)

    println("exclusive range v2")
    for (i in 1 until 10) println(i)

    println("inclusive range, step 2")
    for (i in 1 .. 10 step 2) println(i)

    println("descending range")
    for (i in 10 downTo 1) println(i)

    //arrays
    println("iterating over collection")
    val anArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for (elem in anArray) println(elem)

    // while loops
    println("while loop")
    var i = 0
    while (i<=10){
        println(i)
        i += 1
    }

    // do-while
    println("do-while loop")
    var j = 10
    do {
        println(j)
        j -= 1
    } while (j >= 1)

}