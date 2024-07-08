package com.vishnuraman.oop

object Generics {
    // goal - reuse code/logic on many (potentially unrelated) types
    // linked list
    // "head" = first element
    // "tail" = the rest of the list = a linked list
    // [1,2,3,4] -> head = 1, tail = [2,3,4]

    interface MyIntLinkedList {
        fun head(): Int
        fun tail(): MyIntLinkedList
        // many more methods
//        fun add(elem: Int): MyLinkedList
//        fun contains(elem: Int): Boolean
    }

    class EmptyIntList: MyIntLinkedList {
        override fun head(): Int = throw NoSuchElementException("empty list")
        override fun tail(): MyIntLinkedList = throw NoSuchElementException("empty list")
    }

    class NonEmptyIntList(private val h: Int, private val t: MyIntLinkedList): MyIntLinkedList {
        override fun head(): Int = h
        override fun tail(): MyIntLinkedList = t
    }

    // you have a linked list of integers
    // how do you add a linked list of Strings?
    // 1 - duplicate interface for all types
    // 2- use Any, however we lose type safety

    // GENERICS
    interface MyLinkedList<A> {
        fun head(): A
        fun tail(): MyLinkedList<A>

        companion object {
            fun <A> single(elem: A): MyLinkedList<A> =
                NonEmptyList(elem, EmptyList())
        }
    }

    class EmptyList<A>:  MyLinkedList<A> {
        override fun head(): A = throw NoSuchElementException("empty list")
        override fun tail(): MyLinkedList<A> = throw NoSuchElementException("empty list")
    }

    class NonEmptyList<A>(private val h: A, private val t: MyLinkedList<A>): MyLinkedList<A> {
        override fun head(): A = h
        override fun tail(): MyLinkedList<A> = t
    }

    /**
     * No code duplication
     * can support any type, even unrelated types
     * maintained type safety
     * - homogenous lists
     * - correct type returned
     * - enforce correct types
     */

    // generic features in Kotlin
    // can specify multiple type arguments
    interface MyMap<K, V>

    // generic functions

    // objects CANNOT have generic type arguments
    // companion objects: can use generic method

    @JvmStatic
    fun main(args: Array<String>) {
        val simpleNumbers = NonEmptyIntList(1, NonEmptyIntList(2, NonEmptyIntList(3, NonEmptyIntList(4, EmptyIntList()))))
        val simpleNumbersV2 = NonEmptyList(1, NonEmptyList(2, NonEmptyList(3, NonEmptyList(4, EmptyList()))))
        val meaningOfLife = simpleNumbersV2.head() + 41

        val simpleStrings = NonEmptyList("I", NonEmptyList("love", NonEmptyList("Kotlin", EmptyList())))

        val singleNumber = MyLinkedList.single( 42)
        val singleString = MyLinkedList.single( "love")

    }
}