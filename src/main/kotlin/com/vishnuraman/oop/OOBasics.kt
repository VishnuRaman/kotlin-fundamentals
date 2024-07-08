package com.vishnuraman.oop

// object-oriented programming

class Person(val firstName: String = "Jane", lastName: String = "Doe", age: Int = 0)  { // PRIMARY constructor
    // can define vals, vars, functions
    // can define PROPERTIES (data = vals, vars) and METHODS (behaviour = functions)
    val fullName = "$firstName $lastName"  // <- PROPERTY

    fun greet() = // METHOD
        "Hello everyone, my name is $firstName"

    var favMovie: String = "Forrest Gump"
        // no backing field (= no memory zone for this var)
        get()  = field // get() again if you set to favMovie
        set(value: String) {
            println("$value has been set to $favMovie")
            field = value
        }
    // read ("get"), write ("set")

//    fun getFavMovie() = favMovie
//    fun setFavMovie(movie: String) {
//        favMovie = movie
//    }

    /*
      Properties with get() and/or set(value) may or may not have backing fields (= memory zones for them).
      Create a backing field simply by using `field` in the implementation of get() or set().
      The compiler detects if you have a backing field or not.
      - if you have a backing field, you MUST initialize the property
      - if you don't have a backing field, you CANNOT initialize the property
   */

    // initialization
    lateinit var favLanguage: String
    fun initializeFavLang() {
        if  (!this::favLanguage.isInitialized)
            favLanguage = "Kotlin"
    }

    init {
        // run arbitrary code when this class is being instantiated
        println("initialising a Person with a name $firstName $lastName")
    }

    init {
        println("initializing some other arbitrary code")
    }

    // OVERLOADING = multiple methods with the same name and different signatures
    fun greet(firstName: String) =
        "Hi $firstName, my name is ${this.firstName}"

    // secondary (overloaded) constructors
    // MUST always invoke another constructor
    // alternative, we can give default arguments to class
    constructor(firstName: String, lastName: String):this(firstName, lastName, 0)
    constructor(): this("Jane", "Doe")
}

// immutable = data cannot be changed, must create another instance -> makes code easier to read and less error-prone and bug prone
// mutable = data CAN be changed without allocating another instance


fun main(args: Array<String>) {
    val vishnu = Person("vishnu", "raman", 32)
    val vishnuFullName = vishnu.fullName

    println(vishnuFullName)
    println(vishnu.greet())
    println(vishnu.greet("Anna"))

    val simplePerson = Person()
    println(simplePerson.fullName)

    // get and set
    println("getters and setters")
    println(vishnu.favMovie) // calling the get() method on the favMovie property
    vishnu.favMovie = "Die hard"
    println(vishnu.favMovie)

}