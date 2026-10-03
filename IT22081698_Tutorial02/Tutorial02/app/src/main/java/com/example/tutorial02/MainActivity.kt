package com.example.tutorial02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial02.model.MyCredentials

class MainActivity : AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var rePassword: EditText
    private lateinit var btnSubscribe: Button
    private lateinit var btnCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.username)
        email = findViewById(R.id.edtEmail)
        password = findViewById(R.id.edtSavePassword)
        rePassword = findViewById(R.id.edtPasswordCheck)
        btnSubscribe = findViewById(R.id.btnSubscribe)
        btnCancel = findViewById(R.id.btnRegisterBack)

        btnSubscribe.setOnClickListener {
            subscribe()
        }

        btnCancel.setOnClickListener {
            cancel()
        }
    }

    private fun subscribe() {
        val enteredUsername = username.text.toString().trim()
        val enteredEmail = email.text.toString().trim()
        val enteredPassword = password.text.toString()
        val repeatedPassword = rePassword.text.toString()

        if (enteredUsername.isBlank() || enteredEmail.isBlank()) {
            Toast.makeText(
                this,
                getString(R.string.complete_all_fields),
                Toast.LENGTH_LONG
            ).show()
            return
        }

        val passwordSaved = MyCredentials.setPassword(
            enteredPassword,
            repeatedPassword
        )

        if (passwordSaved) {
            MyCredentials.username = enteredUsername
            MyCredentials.email = enteredEmail

            Toast.makeText(
                this,
                getString(R.string.passwords_match),
                Toast.LENGTH_LONG
            ).show()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(
                this,
                getString(R.string.passwords_do_not_match),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun cancel() {
        Toast.makeText(
            this,
            getString(R.string.not_registered),
            Toast.LENGTH_LONG
        ).show()
        finish()
    }
}