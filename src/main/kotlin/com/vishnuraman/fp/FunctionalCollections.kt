package com.vishnuraman.fp

object FunctionalCollections {

    fun concatenate(n: Int, s: String): String =
        if (n <= 0) ""
        else s + concatenate(n - 1, s)

    fun demoLists() {
        val numbers = listOf(1, 2, 3, 4, 5)
        // mapping
        val tenxnumbers = numbers.map { it -> it * 10 }
        // may return a different list type
        val kotlinRepeated = numbers.map { concatenate(it, "Kotlin") }

        println(kotlinRepeated)
        // filtering
        val evenNumbers = numbers.filter { it % 2 == 0 }

        // doing something
        evenNumbers.forEach {
            println(it)
        }

        // expand a list
        val expandedList = numbers.flatMap { (1..it).toList() }
        println(expandedList)

        // reducing a list to a single value
        val sum = numbers.fold(0) { sum, number -> sum + number }
        println(sum)
        val sum_v2 = numbers.reduce { sum, number -> sum + number }
        println(sum_v2)

        // processing with predicates
        val firstEven =
            numbers.find { x -> x % 2 == 0 } // returns nullable - the first item in the list passing the predicate
        val evenPrefix =
            numbers.takeWhile { it % 2 == 0 } // returns a list containing the first items of the list, as long as the predicate holds true
        val evenCount = numbers.count { x -> x % 2 == 0 }
        val evenCount_v2 = numbers.filter { it % 2 == 0 }.size // same as above

        // many more
        val stringRep = numbers.joinToString("|", "{", "}") { it.toString() }
        println(stringRep)

    }

    fun demoSets() {
        val numbers = setOf(1, 2, 3, 4, 5)

        // check whether an entire set satisfies a predicate
        val lt10 = numbers.all { it < 10 }
        val lt100 = numbers.all { it >= 100 }
    }

    fun demoMaps() {
        val phonebook = mapOf(
            "Vishnu" to 32,
            "Raman" to 20
        )

        // map, filter, flatMap... -- just for PAIRS not individual items

        // filtering keys
        val sectionA = phonebook.filterKeys { it.startsWith("V") }

        //mapping values
        val addSuffix =
            phonebook.mapValues { it.value * 10 } // map of all pairs with the same keys, but values transformed

        // construct a map with a default value (just to avoid crashes or invalid keys)
        val phonebookWithDefault = phonebook.withDefault { invalidKey -> -90000 }
    }

    /**
     * Exercises
     * 1. you have a list of strings -> return a list of those strings' length
     *  ["kotlin", "is", "cool"] -> [6,2,4]
     * 2. you have two lists of numbers of the same size, return a sum of corresponding elements
     *  [1,2,3,4], [5,6,7,8] -> [6, 8, 10, 12]
     *   use the function .zip
     * 3. two lists of things, return all the combinations as strings, feel free to choose the format
     *  [1,2,3], ["black", "white", "red", "blue"] -> ["1-black", "1-white", "1-red", "1-blue", ...]
     * 4. list of strings, return the concatenation of all the strings
     *  ["kotlin", "is", "cool"] -> "kotliniscool"
     *  - reduce
     *  - fold
     * 5. concatenate "kotlin" a number of times, by using just the standard library API, NOT concatenate(n, s)
     */

    fun exercises() {
        // 1
        val strings = listOf("kotlin", "is", "cool")
        val stringsLength = strings.map { it.length }
        println(stringsLength)

        // 2
        val numbers1 = listOf(1, 2, 3, 4, 5)
        val numbers2 = listOf(6, 7, 8, 9, 10)
        val sums = numbers1.zip(numbers2).map { it.first + it.second }
        val sums_v2 = numbers1.zip(numbers2) { a, b -> a + b }

        // 3
        val numbers = listOf(1, 2, 3)
        val colors = listOf("black", "white", "red", "blue")
        val combinations = numbers.flatMap { number ->
            colors.map { color -> "$number-$color" }
        }
        println(combinations)

        // 4 - joinToString
        val statement = strings.joinToString("")
        println(statement)
        val statement_r = strings.reduce { a, b -> a + b }
        val statement_f = strings.fold("") { a, b -> a + b }

        // 5
        val kotlinx5 = (1..5).joinToString(""){ _ -> "Kotlin"}
        println(kotlinx5)
        val kotlinx5_v2 = (1..5).toList()
            .map {_ -> "Kotlin"}
            .reduce { a, b -> a + b }

        println(kotlinx5_v2)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        exercises()
    }
}