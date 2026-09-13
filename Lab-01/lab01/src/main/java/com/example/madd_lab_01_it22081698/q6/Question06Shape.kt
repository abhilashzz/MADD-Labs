package com.example.madd_lab_01_it22081698.q6

interface Shape {

    fun setup()

    fun draw()
}


class Circle : Shape {

    override fun setup() {
        println("Setting up Circle")
        println("A Circle requires a center point and radius.")
    }

    override fun draw() {
        println("Drawing Circle:")
        println("   ***   ")
        println(" *     * ")
        println("*       *")
        println(" *     * ")
        println("   ***   ")
    }
}


class Rectangle : Shape {

    override fun setup() {
        println("Setting up Rectangle")
        println("A Rectangle requires a width and height.")
    }

    override fun draw() {
        println("Drawing Rectangle:")
        println("**********")
        println("*        *")
        println("*        *")
        println("**********")
    }
}


class Triangle : Shape {

    override fun setup() {
        println("Setting up Triangle")
        println("A Triangle requires three sides.")
    }

    override fun draw() {
        println("Drawing Triangle:")
        println("    *")
        println("   * *")
        println("  *   *")
        println(" *     *")
        println("*********")
    }
}


fun main() {

    val circle = Circle()
    val rectangle = Rectangle()
    val triangle = Triangle()

    println("========== CIRCLE ==========")
    circle.setup()
    circle.draw()

    println()

    println("========== RECTANGLE ==========")
    rectangle.setup()
    rectangle.draw()

    println()

    println("========== TRIANGLE ==========")
    triangle.setup()
    triangle.draw()
}