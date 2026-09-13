package com.example.madd_lab_01_it22081698.q2

fun main() {

    val pi = 3.14

    print("Enter the radius of the circle: ")
    val radius = readln().toDouble()

    val circumference = 2 * pi * radius
    val area = pi * radius * radius

    println()
    println("----- Circle Details -----")
    println("Radius: $radius")
    println("Circumference: $circumference")
    println("Area: $area")
}