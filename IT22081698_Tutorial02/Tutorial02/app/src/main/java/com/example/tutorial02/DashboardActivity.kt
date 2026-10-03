package com.example.tutorial02

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    private lateinit var txtTitle: TextView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        txtTitle = findViewById(R.id.tvTitle)
        btnBack = findViewById(R.id.btnBack)

        val username = intent.getStringExtra(LoginActivity.EXTRA_USER_NAME)
            ?: getString(R.string.username)

        txtTitle.text = getString(R.string.welcome_format, username)

        btnBack.setOnClickListener {
            finish()
        }
    }
}