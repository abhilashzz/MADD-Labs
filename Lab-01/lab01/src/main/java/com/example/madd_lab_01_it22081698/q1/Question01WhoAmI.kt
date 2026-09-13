package com.example.madd_lab_01_it22081698.q1

fun whoAmI(value: Any): String {
    return value::class.simpleName ?: "Unknown Type"
}

fun main() {

    val name = "Kamal"
    val age = 25
    val height = 5.8
    val isStudent = true
    val grade = 'A'
    val salary = 45000.50f
    val population = 1000000L

    println("Value: $name | Type: ${whoAmI(name)}")
    println("Value: $age | Type: ${whoAmI(age)}")
    println("Value: $height | Type: ${whoAmI(height)}")
    println("Value: $isStudent | Type: ${whoAmI(isStudent)}")
    println("Value: $grade | Type: ${whoAmI(grade)}")
    println("Value: $salary | Type: ${whoAmI(salary)}")
    println("Value: $population | Type: ${whoAmI(population)}")
}