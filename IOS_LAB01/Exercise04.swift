// Exercise 04 - Comparison and Logical Operators

let comparisonMark = 72

print(comparisonMark == 72)
print(comparisonMark != 72)
print(comparisonMark > 50)
print(comparisonMark < 50)
print(comparisonMark >= 50)
print(comparisonMark <= 100)


// AND

let logicalMark = 68
let submittedAssignment = true

let passed = logicalMark >= 50 && submittedAssignment

print("Passed: \(passed)")


// OR

let hasStudentID = false
let hasTemporaryPass = true

let canEnter = hasStudentID || hasTemporaryPass

print("Can Enter: \(canEnter)")


// NOT

let isAbsent = false

print("Not Absent: \(!isAbsent)")


// Activity 3

let examMark = 60
let attendance = 85

let eligible = examMark >= 50 && attendance >= 80

print("Eligible: \(eligible)")