package com.vishnuraman.fp

object FunctionValues {

    interface Transformation { // it "is" a function
        operator fun invoke(n: Int): Int
    }

    fun transformList(list: List<Int>, transformation: Transformation): List<Int> {
        val result = mutableListOf<Int>()
        for (n in list) {
            result.add(transformation(n))
        }
        return result
    }

//    fun tenxList(list: List<Int>): List<Int> {
//        val result = mutableListOf<Int>()
//        for (n in list) {
//            result.add(n*10)
//        }
//        return result
//    }
//
//    fun add5List(list: List<Int>): List<Int> {
//        val result = mutableListOf<Int>()
//        for (n in list) {
//            result.add(n+5)
//        }
//        return result
//    }

    fun transformList_v2(list: List<Int>, transformation: (Int) -> Int): List<Int> {
        //                                                 ^^^^^^^^^^^ Function Type
        val result = mutableListOf<Int>()
        for (n in list) {
            result.add(transformation(n))
        }
        return result
    }

    fun <A, B> transformList_v3(list: List<A>, transformation: (A) -> B): List<B> {
        val result = mutableListOf<B>()
        for (n in list) {
            result.add(transformation(n))
        }
        return result
    }

    /*
        Exercises:
        1. Write a function to combine all the elements of a list, using a combination function that you pass as argument
            "reduce"
            reduce([1,2,3,4], +, 0) = 10
            reduce([1,2,3,4], a,b => a * b, 1) = 24
        2. Learn to use APIs that use lambdas - sort a list
           Sort a list of Strings by their length.
     */
    // 1
    fun <A> reduce(list: List<A>, seed: A, op: (A, A) -> A): A {
        var result = seed
        for (n in list) {
            result = op(result, n)
        }
        return result
    }



    fun <A> reduceRec(list: List<A>, seed: A, op: (A, A) -> A): A =
        if (list.isEmpty()) seed
        else reduce(list.drop(1), op(seed, list[0]), op)

    @JvmStatic
    fun main(args: Array<String>) {
        val numbers = listOf(1, 2, 3, 4)


        println(transformList(numbers, object : Transformation {
            override fun invoke(n: Int): Int = n + 5
        }))

        val tenxtransformation = object : Transformation {
            override fun invoke(n: Int): Int = n * 10
        }

        // functional programming = ability to pass functions as arguments, return functions as results!
        // function values
        val tenxFun = fun(x: Int): Int { return x * 10 } // anonymous function = function value
        val tenxFun_v2 = { x: Int -> x * 10 } // same thing - anonymous function AKA LAMBDA

        println(transformList_v2(numbers, tenxFun_v2))

        // .map
        val tenxNumbers = numbers.map({ number -> number * 10 }) // passing a function as an argument
        val tenxNumbers_v2 = numbers.map { x: Int -> x * 10 } // simplified syntax, when the last argument is a lambda
        val tenxNumbers_v3 = numbers.map { x -> x * 3 } // type inference helps
        val tenxNumbers_v4 = numbers.map { it * 10 } // default name is "it", only works for single-arg lambdas
        println(tenxNumbers)

        // multi-arg lambdas
        val adderFun: (Int, Int) -> Int = { a, b -> a + b }

        println(reduce(numbers, 0) { a, b -> a + b })
        println(reduce(numbers, 0) { a, b -> a * b })

        val letters = listOf("a", "b", "c", "d", "e", "f", "g", "h")
        println(reduce(letters,"") { a, b -> "$a$b" })
        println(reduceRec(letters,"") { a, b -> "$a$b" })

        val words = listOf("I", "love", "Kotlin", "but", "not", "as", "much", "as", "scala")

        val sortedWords = words.sortedBy { it.length } // ascending sort by this criterion
        println(sortedWords)
    }
}