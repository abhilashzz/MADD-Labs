package com.example.madd_lab_01_it22081698.q4

fun main() {

    val names = arrayOf(
        "Amal",
        "Nimal",
        "Kamal",
        "Sunil",
        "Kasun"
    )

    for (index in names.indices) {
        println("Index: $index | Name: ${names[index]}")
    }
}