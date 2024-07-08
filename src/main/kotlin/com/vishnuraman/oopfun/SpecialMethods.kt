package com.vishnuraman.oopfun

object SpecialMethods {
    // special methods in Java/JVM: equals, hasCode, toString
    class Person(val name: String, val age: Int) {
        override fun equals(other: Any?): Boolean = when (other) {
            is Person -> name == other.name && age == other.age
            else -> false
        }

        // a "unique" number for this instance
        // 2 "equal" instances should produce the same hashCode
        // used in hash-based data structures (sets, maps)
        override fun hashCode(): Int =
            name.hashCode() * 31 + age

        override fun toString(): String {
            return "Person(name='$name', age=$age)"
        }

        // infix methods - syntax sugar
        infix fun likes(movie: String) =
            "$name says: I LOVE $movie"

        /*
            this < another => this.compareTo(another) < 0
            this > another => this.compareTo(another) > 0
            same for <=, >=
            IMPORTANT: if this.equals(another), then make sure that
                this.compareTo(another) == 0
         */
        operator fun compareTo(another: Person) : Int =
            this.age - another.age


    }

    class ComplexNumber(var re: Double, var im: Double) {
        // operator overloading - arithmetic operator
        // plus, minus, times, div, rem
        // 5 % 3 == 5.rem(3)
        operator fun plus(other: ComplexNumber) = ComplexNumber(re + other.re, im + other.im)

        operator fun plus(number: Double) = ComplexNumber(re + number, im + number)

        // var x = 2
        // x += 5
        // compound operators - must return Unit
        // plusAssign, minusAssign, .....
        operator fun plusAssign(number: Double): Unit {
            re += number // re = re + number
        }

        // inc, dec
        // x++
        operator fun inc(): ComplexNumber = ComplexNumber(re + 1, im)

        // unary operator
        // -x
        // unaryPlus, unaryMinus -> for -x and +x
        operator fun unaryMinus(): ComplexNumber = ComplexNumber(-re, -im)

        // access elements
        // cn[0], cn[1]
        operator fun get(index: Int): Double =
            when(index) {
                0 -> re
                1 -> im
                else -> throw IllegalArgumentException("Complex numbers only have 2 fields")
            }

        // matrix[r, c] == matrix.get(r, c)
        // cn[1,0]
        operator fun get(index1: Int, index2: Int): Double =
            get(index1) + get(index2)

        operator fun get(part: String): Double =
            when(part) {
                "re" -> re
                "im" -> im
                else -> throw IllegalArgumentException("Invalid field")
            }

        // cn[1] = 4.3
        operator fun set(index: Int, value: Double): Unit =
            when(index) {
                0 -> re = value
                1 -> im = value
                else -> throw IllegalArgumentException("Complex numbers only have 2 fields")
            }

        // contains operator
        // 2.0 in [1,2,3]
        // useful for collections
        operator fun contains(v: Double): Boolean =
            re == v || im == v

        // destructuring operators (Python-style declaration)
        // val (x, y) = cn
        operator fun component1(): Double = re
        operator fun component2(): Double = im
        operator fun component3() = Math.sqrt(re * re + im * im)

        // how you "call" this instance like a function
        operator fun invoke(origin: ComplexNumber) = ComplexNumber(re - origin.re, im - origin.im)

        override fun toString(): String {
            return "ComplexNumber($re, $im)"
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val person = Person("Vishnu", 32)
        val person2 = Person("Vishnu", 5)

        println(person == person2)
        println(person)

        println(person.likes("Forrest Gump"))
        println(person likes "Forrest Gump") // same expression
        //              ^^^^ infix position

        val cn = ComplexNumber(1.2, 2.6)
        val anotherCn = ComplexNumber(0.6, 1.5)
        println(cn.plus(anotherCn)) // standard
        println(cn + anotherCn) // same expression
        println(cn + 6.7)
        println(-cn)
        cn += 8.8

        // comparison
        println(person2 < person) // person2.compareTo(person)

        // accessors
        println(cn[0])
        println(cn["re"])

        cn[1] = 4.3
        println(cn[1]) // cn.set(1, 4.3)

        println(2.0 in cn) // same as cn.contains(2.0)

        /*
            val x = cn.component1()
            val y  = cn.component2()
         */
        val (x, y) = cn
        println(x)
        println(y)

        val (a,b,l) = cn
        println(l)

        val relative = cn(anotherCn) // same as cn.invoke(anotherCn)

    }


}