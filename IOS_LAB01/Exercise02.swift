// Exercise 02 - Swift Data Types and Type Inference

// Type inference

let studentName = "Kamal"
let studentAge = 22
let gpa = 3.65
let isRegistered = true

print(type(of: studentName))
print(type(of: studentAge))
print(type(of: gpa))
print(type(of: isRegistered))

// Type annotations

let annotatedName: String = "Kamal"
let annotatedAge: Int = 22
let annotatedGPA: Double = 3.65
let registered: Bool = true
let grade: Character = "A"

print(annotatedName)
print(annotatedAge)
print(annotatedGPA)
print(registered)
print(grade)

// Activity 2

let activityStudentID: String = "IT22081698"
let activityStudentName: String = "Abhilash K A T W"
let year: Int = 4
let activityGPA: Double = 3.65
let activityRegistered: Bool = true
let activityGrade: Character = "A"

print("Student ID: \(activityStudentID)")
print("Student Name: \(activityStudentName)")
print("Year: \(year)")
print("GPA: \(activityGPA)")
print("Registered: \(activityRegistered)")
print("Grade: \(activityGrade)")
