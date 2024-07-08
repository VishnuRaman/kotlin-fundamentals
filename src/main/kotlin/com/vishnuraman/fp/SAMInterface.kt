package com.vishnuraman.fp

object SAMInterface {

    fun runNTimes(n: Int, runnable: Runnable) {
        (1..n).forEach { _ ->
            runnable.run()
        }
    }

    // no luxury to say this
    fun runNTimesFunc(n: Int, func: () -> Unit) {
        (1..n).forEach { _ ->
            func()
        }
    }

    fun demoRunnable() {
        runNTimes(0, object : Runnable {
            override fun run() {
                println("this is a runnable")
            }
        })

        runNTimesFunc(10) { println("this is a function") }
    }

    // SAM  = single abstract method

    fun demoRunnable_v2() {
        runNTimes(10) { println("this is a runnable") } // syntax sugar granted by Kotlin
        /*
            rewritten by the compiler to
            runNTimes(10, object: Runnable {
                override fun run() {
                println("this is a runnable")
            })
         */
        // works automatically with SAM interfaces from JAVA
    }

    fun interface Transformer { // SAM interface
        // can only have one abstract method
        fun process(n: Int): Int
        // can rewrite a Transformer to (Int) -> Int
        // compiler can replace a Transformer with (Int) -> Int
    }

    fun processNTimes(seed: Int, n: Int, transformer: Transformer): Int =
        if (n <= 0) seed
        else processNTimes(transformer.process(seed), n - 1, transformer)

    @JvmStatic
    fun main(args: Array<String>) {
        println(processNTimes(0, 10) { n -> n + 1 })
    }
}