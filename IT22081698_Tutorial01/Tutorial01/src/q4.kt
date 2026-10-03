// 1. Classes and 2. Inheritance
open class Shape

class Rectangle(var length: Double, var width: Double) : Shape() {
    var perimeter: Double = (length + width) * 2
}

class Person(name: String) {
    val name = "Name is $name".also(::println)

    init {
        println("First initializer block that prints the $name")
    }

    val nameSize = "name size is ${name.length}".also(::println)

    init {
        println("Second initializer block that prints the ${name.length}")
    }
}

fun main() {
    val student = Person("John Smith")
    var square1 = Rectangle(4.0, 4.0)
    println(square1.perimeter)
}