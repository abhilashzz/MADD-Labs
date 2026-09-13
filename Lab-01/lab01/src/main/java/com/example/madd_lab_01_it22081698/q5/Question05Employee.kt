package com.example.madd_lab_01_it22081698.q5

abstract class Employee(
    val employeeId: Int,
    val name: String,
    val basicSalary: Double
) {

    abstract fun calculateSalary(): Double

    abstract fun displayEmployeeType()

    fun displayBasicDetails() {
        println("Employee ID: $employeeId")
        println("Name: $name")
        println("Basic Salary: LKR $basicSalary")
    }
}


class TemporaryStaff(
    employeeId: Int,
    name: String,
    basicSalary: Double,
    val contractMonths: Int,
    val overtimeHours: Int,
    val overtimeRate: Double
) : Employee(employeeId, name, basicSalary) {

    override fun calculateSalary(): Double {
        return basicSalary + (overtimeHours * overtimeRate)
    }

    override fun displayEmployeeType() {
        println("Employee Type: Temporary Staff")
    }

    fun displayContractDetails() {
        println("Contract Duration: $contractMonths months")
        println("Overtime Hours: $overtimeHours")
        println("Overtime Rate: LKR $overtimeRate")
    }
}


class PermanentStaff(
    employeeId: Int,
    name: String,
    basicSalary: Double,
    val bonus: Double,
    val medicalAllowance: Double
) : Employee(employeeId, name, basicSalary) {

    override fun calculateSalary(): Double {
        return basicSalary + bonus + medicalAllowance
    }

    override fun displayEmployeeType() {
        println("Employee Type: Permanent Staff")
    }

    fun displayBenefits() {
        println("Bonus: LKR $bonus")
        println("Medical Allowance: LKR $medicalAllowance")
    }
}


fun main() {

    val temporaryStaff = TemporaryStaff(
        employeeId = 101,
        name = "Kamal",
        basicSalary = 50000.0,
        contractMonths = 6,
        overtimeHours = 10,
        overtimeRate = 1000.0
    )

    val permanentStaff = PermanentStaff(
        employeeId = 201,
        name = "Nimal",
        basicSalary = 80000.0,
        bonus = 15000.0,
        medicalAllowance = 5000.0
    )

    println("========== TEMPORARY STAFF ==========")

    temporaryStaff.displayEmployeeType()
    temporaryStaff.displayBasicDetails()
    temporaryStaff.displayContractDetails()
    println("Total Salary: LKR ${temporaryStaff.calculateSalary()}")

    println()

    println("========== PERMANENT STAFF ==========")

    permanentStaff.displayEmployeeType()
    permanentStaff.displayBasicDetails()
    permanentStaff.displayBenefits()
    println("Total Salary: LKR ${permanentStaff.calculateSalary()}")
}