package com.example.madd_lab_01_it22081698.q3

fun greetings(name: String, age: Int) {

    println("Hello $name!")
    println("You are $age years old.")

    if (age >= 18) {
        println("You are eligible to apply for a driving license.")
    } else {
        println("You are not eligible to apply for a driving license.")
        println("You need to wait ${18 - age} more year(s).")
    }
}

fun main() {

    print("Enter your name: ")
    val name = readln()

    print("Enter your age: ")
    val age = readln().toInt()

    println()

    greetings(name, age)
}