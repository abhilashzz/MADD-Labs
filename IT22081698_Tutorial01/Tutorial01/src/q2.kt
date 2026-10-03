// 3. Conditional Expressions & 4. Iterations
fun main() {
    var r = 7
    if (r > 5) {
        println("r is greater than 5")
    } else {
        println("r is less than 5")
    }

    val names = listOf("John", "Jane", "Tom", "Jack", "Anne", "Kane")
    var i = 0

    for (name in names) {
        println("Hello, $name")
    }

    while (i < names.size) {
        println("name at $i is ${names[i]}")
        i++
    }
}

// 5. When expression in Kotlin
fun whatIs(obj: Any): String =
    when (obj) {
        1 -> "one"
        "Hello" -> "Greetings"
        is Long -> "Long"
        !is String -> "not a string"
        else -> "Unknown"
    }