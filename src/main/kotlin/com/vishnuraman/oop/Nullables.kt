package com.vishnuraman.oop

object Nullables {

    class Developer(val name: String, val favLanguage: String) {
        fun writeCode(code: String = "") {
            println("$name writing code in $favLanguage: $code")
        }
    }

    // null = no value
    // Developer daniel = null;
    // val daniel: Developer = null; -> not possible in Kotlin
    
    val maybeDeveloper: Developer? = null // possible
    
    fun createdeveloper(name: String): Developer? =
        if (name.isNotEmpty()) Developer(name, "Kotlin")  // compiler KNOWS that the value is not null
        else null
        

    val maybeDeveloper_v2: Developer? = createdeveloper("VishnuRaman")
    // once you have a nullable, you CANNOT access properties or methods
    // val vishnu = maybeDeveloper_v2.name -> not possible

    fun makeDevWriteCode(dev: Developer?, code: String) =
        if (dev != null) dev.writeCode(code) // 'flow typing'
        else println("Error: developer is null")

    // if you know that a nullable is not null, then you can force the value to be of concrete type
    val masterYoda = maybeDeveloper_v2!! // type is now concrete
    // if you're wrong, then it will crash with NPE
    // do NOT USE !! unless you REALLY know what you're doing

    // safe call operator ?. + property or methods
    val maybeName: String? = maybeDeveloper?.name

    // Elvis operator ?:
    val definitiveDeveloper: Developer = maybeDeveloper ?: Developer("john doe", "Cobol")

    fun makeDevWriteCode_v2(dev: Developer?, code: String) =
        dev?.writeCode(code) ?: println("Error: developer is null")

    // side note: safe casting
    val something: Any = 42
    // if you know you have an Int, you can cast it down
    val anInt = something as Int // crash if you are wrong
    val maybeInt = something as? Int   // doesnt crash -> nullable Int


    @JvmStatic
    fun main(args: Array<String>) {
        makeDevWriteCode(maybeDeveloper_v2, "val x = 42")
        makeDevWriteCode(null, "val x = 42")
        masterYoda.writeCode("some code in Kotlin")
        maybeDeveloper_v2?.writeCode("some code in Kotlin")

    }
}