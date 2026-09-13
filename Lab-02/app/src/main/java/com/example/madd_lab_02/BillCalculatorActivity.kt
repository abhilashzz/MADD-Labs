package com.example.madd_lab_02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class BillCalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bill_calculator)

        val etUnits =
            findViewById<EditText>(R.id.etUnits)

        val btnCalculate =
            findViewById<Button>(R.id.btnCalculate)

        val tvElectricityBill =
            findViewById<TextView>(R.id.tvElectricityBill)

        btnCalculate.setOnClickListener {

            val unitsText =
                etUnits.text.toString().trim()

            if (unitsText.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please enter the number of units",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val units =
                unitsText.toDoubleOrNull()

            if (units == null || units < 0) {

                Toast.makeText(
                    this,
                    "Please enter a valid number of units",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val bill =
                calculateBill(units)

            tvElectricityBill.text =
                String.format(
                    Locale.getDefault(),
                    "Electricity Bill: LKR %.2f",
                    bill
                )
        }
    }

    private fun calculateBill(units: Double): Double {

        val fixedCharge = 150.0
        val unitCost = 29.0
        val vatRate = 0.15

        val energyCharge =
            units * unitCost

        val subtotal =
            fixedCharge + energyCharge

        val vat =
            subtotal * vatRate

        val finalBill =
            subtotal + vat

        return finalBill
    }
}