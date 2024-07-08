package com.vishnuraman.oopfun

object NestedInnerClasses {

    class Outer {
        val aProp = 4

        // nested class == "static" class
        // depends on the Outer TYPE
        // no connection with any INSTANCE of Outer
        class Nested {
            val nestedProp = 42
            // val summedProp = aProp + 10 -> not allowed
        }

        // inner class
        // depends on the current INSTANCE that created Inner
        inner class Inner {
            val innerProp = aProp + 10
            val outerInstance = this@Outer
            //                  ^^^^^^^^^ -> "qualified this"
        }
    }

    fun demoClasses() {
        // nested
        val nested  = Outer.Nested()
        println(nested.nestedProp)

        // inner
        val outer = Outer()
        val inner = outer.Inner()
        println(inner.innerProp)
    }

    // nested classes are useful when the nested types are conceptually tied to the wrapping (outer) type
    // and they are relevant for the _definition_ of a particular service
    interface MyProtocol {
        sealed class Message
        data class Start(val nPlayers: Int): Message()
        data class GameEvent(val type: String, val playerId: String): Message()
        // ...
    }

    val gameMessage: MyProtocol.Message = MyProtocol.Start(5)

    // inner classes are useful when the types are tied to the _implementation_ of the wrapping INSTANCE
    class MyPermissionsService {
        // only relevant in THIS INSTANCE
        open inner class Role(name: String)
        inner class Admin: Role("ADMIN")
        inner class Moderator: Role("MODERATOR")
        inner class Player: Role("PLAYER")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        demoClasses()
    }
}