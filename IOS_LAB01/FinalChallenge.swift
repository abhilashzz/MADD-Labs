// Final Practical Task - Student Result Analyzer

let studentName = "Abhilash K A T W"
let studentID = "IT22081698"
let moduleCode = "SE4041"

let assignmentMark = 85.0
let examMark = 70.0

var email: String? = "abhilash@gmail.com"


// Calculate final mark

let finalMark =
    (assignmentMark * 0.40) +
    (examMark * 0.60)


// Determine pass status

let passed = finalMark >= 50


// Safely handle optional email

let displayEmail = email ?? "Not Provided"


// Display report

print("================================")
print("STUDENT RESULT")
print("================================")
print("Student Name : \(studentName)")
print("Student ID : \(studentID)")
print("Module : \(moduleCode)")
print("Assignment Mark : \(assignmentMark)")
print("Exam Mark : \(examMark)")
print("Final Mark : \(finalMark)")
print("Passed : \(passed)")
print("Email : \(displayEmail)")