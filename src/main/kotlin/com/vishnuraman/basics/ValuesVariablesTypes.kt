package com.vishnuraman.basics

fun main(args: Array<String>) {
   // statically-typed language
    val meaningOfLife = 42

    var objectiveInLife = 32
    objectiveInLife = 24

    // type inference = compiler figures out the type from the RHS of the assignment
    val meaningOfLive_v2 = 42
    val meaningOfLive_v3 = 40 + 5

    val aBoolean: Boolean = true // false
    val aChar: Char = 'a'
    val aByte: Byte = 127 // 1 byte representation
    val aShort: Short = 32767 // 1234
    val anInt: Int = 42 // 4 bytes
    val anLong: Long = 42L // 8 bytes
    val anFloat: Float = 0.0f // 4 bytes
    val aDouble: Double = 12.0 // 8 bytes


    // string
    val aString: String = "Hello World"


}

// top-level values = constants
const val appWideMoL = 42 // computed first