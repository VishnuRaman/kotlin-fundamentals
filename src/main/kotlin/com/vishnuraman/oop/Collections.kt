package com.vishnuraman.oop

object Collections {

    // lists
    fun demoLists() {
        // immutable
        val aList: List<Int> = listOf(1, 2, 3)
        val thirdElement = aList[2]
        val length = aList.size

        // other API
        val find3 = aList.indexOf(3) // index of 3, otherwise -1 if 3 does not exist in the list
        val subList = aList.subList(1, 2) // from(inclusive), to(exclusive) => [2]
        val has3 = aList.contains(3) // boolean
        val with4 = aList.plus(4) // NEW LIST -> [1,2,3,4]
        // plus others (FP)

        // mutable lists
        val mutableList = mutableListOf(1, 2, 3)
        mutableList.add(0, 42) // put a 42 at index 0, pushes everything else 1 index further -> [42,1,2,3]
        mutableList.remove(0) // cuts the item out, pulls everything 1 index closer
        mutableList.set(1, 56) // changes the element at this index
        mutableList[1] = 56 // same thing, C-style syntax
        println(mutableList)

        // work best with immutable lists
    }

    // arrays - map to JVM arrays - map to OS-level arrays (very fast)
    // always mutable
    fun demoArrays() {
        val anArray: Array<Int> = arrayOf(1, 2, 3) // [1,2,3]
        // only have "get" and "set"
        val secondItem = anArray[1] // 0 indexed
        anArray[1] = 100
        val length = anArray.size

        for (i in 0..<anArray.size) // iterate through elements of collections - for lists, arrays, sets
            println(anArray[i])
    }

    // sets - do not contain duplicates
    // immutable
    fun demoSets() {
        val aSet = setOf(1, 2, 3, 4, 1, 2, 3) // will only contain 1,2,3 just once
        // API - contains
        val contains1 = aSet.contains(1) // true if 1 is in the set - constant time
        val contains1_v2 = 1 in aSet // Kotlin specific syntax sugar
        // secondary APIs
        val add7 = aSet.plus(7) // returns ANOTHER set with 7 included
        val add7_v2 = aSet + 7 // same thing (syntax sugar)
        val without3 = aSet.minus(3) // returns another set with 3 removed
        val without3_v2 = aSet - 3 // same
        val combined = aSet.plus(setOf(7, 8, 9)) // combine two sets
        val diff = aSet.minus(setOf(3, 4, 5))
        val intersect = aSet.intersect(setOf(3, 4, 5)) // a new set with just common elements -> [3,4]

        // mutable
        val mutableSet = mutableListOf(1, 2, 3, 4, 1, 2, 3, 4, 5, 6)
        mutableSet.add(9)
        mutableSet.remove(4)
        // same secondary APIs
    }

    // maps - key-value pair associations (key is unique)
    fun demoMaps() {
        val phonebook = mapOf(
            Pair("Vishnu", 123),
            "Raman" to 456, // syntax sugar for Pair("Raman", 456)
        )

        // fundamental API
        val hasAlice = phonebook.contains("Raman") // true if "Raman" is a key in the map
        val aliceNumber = phonebook.get("Raman") // gets the value associated to the key "Raman"
        val aliceNumber_v2 = phonebook["Raman"] // will crash if the key does not exist

        // secondary API
        val newMap = phonebook.plus("Bob" to 6787) // new map with the new association
        val withoutVishnu = phonebook.minus("Vishnu") // new map with "Vishnu" removed
        val pairs: List<Pair<String, Int>> = phonebook.toList() // returns a list of Pairs
        val pairs_v2 = listOf(
            Pair("Vishnu", 123),
            "Raman" to 456,
        )
        val phonebook_v2 = pairs_v2.toMap() // only for lists of pairs

        // mutable
        val mutablePhonebook = mutableMapOf(
            Pair("Vishnu", 123),
            "Raman" to 456,
        )
        mutablePhonebook.remove("Vishnu") // changes the same instance
        mutablePhonebook.put("Bob", 66954)


    }

    @JvmStatic
    fun main(args: Array<String>) {
        demoLists()
        demoArrays()
    }
}