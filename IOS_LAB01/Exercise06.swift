// Exercise 06 - Understanding Optionals

// Creating an optional

var middleName: String? = "Nimal"

print(middleName as Any)

middleName = nil

print(middleName as Any)


// Conversion returns an optional

let validNumber = Int("25")
let invalidNumber = Int("Hello")

print(validNumber as Any)
print(invalidNumber as Any)


// Force unwrapping

var forceUnwrapName: String? = "Kamal"

print(forceUnwrapName!)

// Unsafe example:
// forceUnwrapName = nil
// print(forceUnwrapName!)
// This would crash because the optional contains nil.


// Safe unwrapping using if let

var safeStudentName: String? = "Kamal"

if let name = safeStudentName {
    print("Student Name: \(name)")
} else {
    print("Student name is not available")
}

safeStudentName = nil

if let name = safeStudentName {
    print("Student Name: \(name)")
} else {
    print("Student name is not available")
}


// Unwrapping multiple optionals

var firstName: String? = "Kamal"
var lastName: String? = "Perera"

if let first = firstName, let last = lastName {
    print("Full Name: \(first) \(last)")
} else {
    print("Complete name is not available")
}

lastName = nil

if let first = firstName, let last = lastName {
    print("Full Name: \(first) \(last)")
} else {
    print("Complete name is not available")
}


// Nil-coalescing operator

var nickname: String? = nil

let displayName1 = nickname ?? "No Nickname"

print(displayName1)

nickname = "Kama"

let displayName2 = nickname ?? "No Nickname"

print(displayName2)


// Activity 5 - Optional Student Details

var detailFirstName: String? = "Kamal"
var detailLastName: String? = "Perera"
var email: String? = nil

if let first = detailFirstName, let last = detailLastName {
    print("Full Name: \(first) \(last)")
} else {
    print("Complete name is not available")
}

let displayEmail = email ?? "Not Provided"

print("Email: \(displayEmail)")


// Knowledge Check

// 1. let creates a constant; var creates a variable.

// 2. Type inference means Swift automatically determines
//    the data type from the assigned value.

// 3. Int stores whole numbers.
//    Double stores decimal numbers.

// 4. Swift requires explicit conversion because it is type safe.

// 5. % calculates the remainder after division.

// 6. String interpolation inserts values into strings using \(value).

// 7. String? means the variable may contain a String or nil.

// 8. nil means that no value exists.

// 9. Force unwrapping can crash the program if the optional is nil.

// 10. if let safely unwraps an optional when a value exists.

// 11. ?? uses an optional value when available,
//     otherwise it uses a default value.