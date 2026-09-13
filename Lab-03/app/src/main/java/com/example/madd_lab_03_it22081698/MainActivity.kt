package com.example.madd_lab_03_it22081698

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Load the calculator screen only when the activity
        // is created for the first time.
        if (savedInstanceState == null) {

            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.fragmentContainer,
                    CalculatorFragment()
                )
                .commit()
        }
    }

    fun openAnswerScreen(
        result: Double,
        expression: String
    ) {

        val answerFragment =
            AnswerFragment.newInstance(
                result,
                expression
            )

        supportFragmentManager
            .beginTransaction()
            .setReorderingAllowed(true)
            .replace(
                R.id.fragmentContainer,
                answerFragment
            )
            .addToBackStack("answer")
            .commit()
    }
}