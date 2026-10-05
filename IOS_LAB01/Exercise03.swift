// Exercise 03 - Type Conversion and Operators

// Type conversion

let students = 42
let averageGPA = 3.75

let convertedResult = Double(students) + averageGPA

print("Converted Result: \(convertedResult)")


// Arithmetic operators

let a = 17
let b = 5

print("Addition: \(a + b)")
print("Subtraction: \(a - b)")
print("Multiplication: \(a * b)")
print("Integer Division: \(a / b)")
print("Remainder: \(a % b)")

let decimalResult = Double(a) / Double(b)

print("Decimal Division: \(decimalResult)")


// Calculate an average

let mark1 = 75
let mark2 = 82
let mark3 = 68

let total = mark1 + mark2 + mark3
let average = Double(total) / 3.0

print("Total: \(total)")
print("Average: \(average)")


// Remainder operator

let number = 28

print("Remainder when divided by 2: \(number % 2)")

let isEven = number % 2 == 0

print("Is Even: \(isEven)")