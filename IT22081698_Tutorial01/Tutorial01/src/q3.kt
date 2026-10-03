fun main() {
    // 6. Collections (Lists, Sets, Maps)
    val mutableNumbers = mutableListOf(1, 2, 3, 4, 5)
    mutableNumbers.add(6)

    val uniqueNumbers = setOf(1, 2, 3, 2, 4, 5)

    val mutableCapitals = mutableMapOf("USA" to "Washington D.C.", "UK" to "London")
    mutableCapitals["Germany"] = "Berlin"

    // 7. Collection Operations
    val filteredNumbers = mutableNumbers.filter { it > 3 }
    val squaredNumbers = mutableNumbers.map { it * it }

    val names = listOf("Alice", "Bob", "Charlie", "Anna")
    val groupedNames = names.groupBy { it.first() }
}