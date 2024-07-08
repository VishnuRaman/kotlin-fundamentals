package com.vishnuraman.oopfun

object ValueClasses {
    // wrapper types ("boxing")
    // value class
    // downside = memory overhead
    // @JvmInline value clases do not do ANY boxing
    @JvmInline value class ProductName(val name: String)
    @JvmInline value class ProductDescription(val description: String)
//  ^^^^^^^^^^ necessary if the compile target is the JVM

    data class Product(val name: ProductName, val description: ProductDescription) // 37 fields



    val kotlinCourse = Product(ProductName("Kotlin Course"), ProductDescription("Learn kotlin"))



    @JvmStatic
    fun main(args: Array<String>) {

    }
}