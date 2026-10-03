// 1. Variables & Introduction
val pi = 3.14
var r = 0

fun main(args: Array<String>) {
    // Read only local variables
    val a: Int = 1
    val b = 2 // 'Int' type is inferred
    val c: Int // Type required when no initializer is provided
    c = 3

    // Variables that can be re-assigned
    var x = 5
    x += 1

    r = 7
    println("Circumference = " + 2 * pi * r)
    println("Area is " + calculateArea(10.0))
}

// 2. Functions
fun calculateArea(r: Double): Double {
    return pi * r * r
}