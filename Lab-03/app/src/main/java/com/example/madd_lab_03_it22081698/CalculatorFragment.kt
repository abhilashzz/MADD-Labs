package com.example.madd_lab_03_it22081698

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class CalculatorFragment : Fragment(R.layout.fragment_calculator) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editNumber1 = view.findViewById<EditText>(R.id.editNumber1)
        val editNumber2 = view.findViewById<EditText>(R.id.editNumber2)

        val buttonAdd = view.findViewById<Button>(R.id.buttonAdd)
        val buttonSubtract = view.findViewById<Button>(R.id.buttonSubtract)
        val buttonMultiply = view.findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide = view.findViewById<Button>(R.id.buttonDivide)

        fun calculate(operation: String) {

            // Remove old error messages
            editNumber1.error = null
            editNumber2.error = null

            val firstText = editNumber1.text.toString().trim()
            val secondText = editNumber2.text.toString().trim()

            // Check first input
            if (firstText.isEmpty()) {
                editNumber1.error = getString(R.string.error_first_number)
                editNumber1.requestFocus()
                return
            }

            // Check second input
            if (secondText.isEmpty()) {
                editNumber2.error = getString(R.string.error_second_number)
                editNumber2.requestFocus()
                return
            }

            // Convert first number
            val number1 = firstText.toDoubleOrNull()

            if (number1 == null) {
                editNumber1.error =
                    getString(R.string.error_invalid_first_number)
                editNumber1.requestFocus()
                return
            }

            // Convert second number
            val number2 = secondText.toDoubleOrNull()

            if (number2 == null) {
                editNumber2.error =
                    getString(R.string.error_invalid_second_number)
                editNumber2.requestFocus()
                return
            }

            // Division by zero validation
            if (operation == "/" && number2 == 0.0) {
                editNumber2.error =
                    getString(R.string.error_divide_zero)
                editNumber2.requestFocus()
                return
            }

            val result = when (operation) {

                "+" -> number1 + number2

                "-" -> number1 - number2

                "*" -> number1 * number2

                "/" -> number1 / number2

                else -> 0.0
            }

            val displaySymbol = when (operation) {
                "*" -> "×"
                "/" -> "÷"
                else -> operation
            }

            val expression =
                "${formatNumber(number1)} $displaySymbol ${formatNumber(number2)}"

            // Open the Answer Fragment
            (requireActivity() as MainActivity)
                .openAnswerScreen(result, expression)
        }

        buttonAdd.setOnClickListener {
            calculate("+")
        }

        buttonSubtract.setOnClickListener {
            calculate("-")
        }

        buttonMultiply.setOnClickListener {
            calculate("*")
        }

        buttonDivide.setOnClickListener {
            calculate("/")
        }
    }

    private fun formatNumber(number: Double): String {

        return if (number % 1.0 == 0.0) {
            number.toLong().toString()
        } else {
            number.toString()
        }
    }
}