package com.vishnuraman.oop

import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import javax.xml.transform.Transformer

object Delegation {

    interface TextTransformer {
        val id: String
        fun transform(text: String): String
        fun getDescription(): String
    }

    open class Translator(open val from: String, open val to: String) : TextTransformer {
        override val id: String = "Translate $from -> $to"
        override fun transform(text: String): String =
            "[${getDescription()}] translating from $from to $to: $text" // perform the translation log

        override fun getDescription(): String = "Translate $from to $to"
    }

    class QuickTranslator(override val from: String, override val to: String) : Translator(from, to) {
        override fun getDescription(): String = "Quick translate $from -> $to"
    }

    class GPT4 : TextTransformer {
        override val id: String = "GPT4"
        override fun transform(text: String): String =
            "[$id] something an AI would say"

        override fun getDescription(): String = "a simple AI"
    }

    val transformer: TextTransformer = Translator("English", "Romanian")
    val transformedText = transformer.transform("This is a Kotlin lesson")

    // debate - composition vs inheritance
    // Decorator pattern -> takes an instance of the API and inherit it as well
    class TextProcessor(private val t: TextTransformer) : TextTransformer {
        override val id: String = t.id
        override fun getDescription(): String = t.getDescription()
        override fun transform(text: String): String =
            t.transform(text) // delegation to t
    }

    // example Decorator Pattern = Java Stream API - InputStream
    val bis = BufferedInputStream(FileInputStream(File("src/main/kotlin/com/vishnuraman/oop/Delegation.kt")))

    val processor = TextProcessor(Translator("English", "Romanian"))
    val transformedText_v2 = processor.transform("This is a Kotlin lesson")

    // Delegation
    class TextProcessorV2(private val t: TextTransformer) : TextTransformer by t { // same as TextProcessorV1
        // can override any method
        //override fun transform(text: String): String = "grammar autocorrect for $text"
        // be caerful with overriden properties/methods
        override fun getDescription(): String = "grammer autocorrector"
    }

    val processorV2 = TextProcessorV2(Translator("English", "Romanian"))
    val transformedText_v3 = processorV2.transform("This is a Kotlin lesson")

    @JvmStatic
    fun main(args: Array<String>) {
        println(transformedText)
        println(transformedText_v2)
        println(transformedText_v3)
        println(QuickTranslator("English", "Romanian").transform("This is a Kotlin lesson"))

    }
}