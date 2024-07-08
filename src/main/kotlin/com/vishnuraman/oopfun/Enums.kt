package com.vishnuraman.oopfun

object Enums {

    // enumeration
    sealed interface PermissionNaive {

        companion object {
            // READ, WRITE, EXECUTE, NONE
            data object READ : PermissionNaive
            data object WRITE : PermissionNaive
            data object EXECUTE : PermissionNaive
            data object NONE : PermissionNaive
        }
    }

    enum class Permission {
      // the cases are the first thing you need to write
        READ, WRITE, EXECUTE, NONE;  // <- ; is important if you want to add new properties or methods
    //   0  ,   1  ,   2    ,  3

        // properties, methods
        val bitSize = 4
        fun openDocument() {
            if (this == READ) {
                println("opening document to read")
            } else {
                println("cannot read document")
            }
        }
    } // final

    // toString, equals, hashCode

    // can pass constructor arguments
    enum class PermissionBitMask(bits: Int) {
        READ(4), // 0100
        WRITE(2), // 0010
        EXECUTE(1), // 0001
        NONE(0)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val read = Permission.READ
        val read_v2 = Permission.READ
        println(read)
        println(read == read_v2)
        // parse an enum from a string
        println(Permission.valueOf("READ") == read)
        // enumerate all values
        println(Permission.entries)
        // calculate the "index" == ordinal
        println(read.ordinal)

        // access properties/methods
        println(read.bitSize)

        read.openDocument()
    }
}