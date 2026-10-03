package com.example.tutorial02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial02.model.MyCredentials

class LoginActivity : AppCompatActivity() {

    private lateinit var tvCreateNewAccount: TextView
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvCreateNewAccount = findViewById(R.id.tvCreateNewAccount)
        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)

        tvCreateNewAccount.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val enteredUsername = edtUsername.text.toString().trim()
        val enteredPassword = edtPassword.text.toString()

        val usernameMatches = enteredUsername == MyCredentials.username
        val passwordMatches = MyCredentials.matchesPassword(enteredPassword)

        if (usernameMatches && passwordMatches) {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra(EXTRA_USER_NAME, enteredUsername)
            startActivity(intent)
        } else {
            Toast.makeText(
                this,
                getString(R.string.login_failed),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    companion object {
        const val EXTRA_USER_NAME = "user_name"
    }
}