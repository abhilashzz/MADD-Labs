package com.example.madd_lab_03_it22081698

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnswerFragment : Fragment(R.layout.fragment_answer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textExpression =
            view.findViewById<TextView>(R.id.textExpression)

        val textAnswer =
            view.findViewById<TextView>(R.id.textAnswer)

        val buttonBack =
            view.findViewById<Button>(R.id.buttonBack)

        val result =
            requireArguments().getDouble(ARG_RESULT)

        val expression =
            requireArguments().getString(ARG_EXPRESSION).orEmpty()

        textExpression.text = expression

        textAnswer.text =
            getString(
                R.string.answer_value,
                formatNumber(result)
            )

        buttonBack.setOnClickListener {

            parentFragmentManager.popBackStack()
        }
    }

    private fun formatNumber(number: Double): String {

        return if (number % 1.0 == 0.0) {
            number.toLong().toString()
        } else {
            number.toString()
        }
    }

    companion object {

        private const val ARG_RESULT = "result"
        private const val ARG_EXPRESSION = "expression"

        fun newInstance(
            result: Double,
            expression: String
        ): AnswerFragment {

            val fragment = AnswerFragment()

            val bundle = Bundle().apply {

                putDouble(ARG_RESULT, result)

                putString(ARG_EXPRESSION, expression)
            }

            fragment.arguments = bundle

            return fragment
        }
    }
}