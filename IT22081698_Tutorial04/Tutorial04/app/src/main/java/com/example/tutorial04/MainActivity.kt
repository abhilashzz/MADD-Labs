package com.example.tutorial04

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private val insertRecordFragment = InsertRecordFragment()
    private val viewRecordsFragment = ViewRecordsFragment()
    private lateinit var btnAdd: Button
    private lateinit var btnView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind the buttons from activity_main.xml
        btnAdd = findViewById(R.id.btnAdd)
        btnView = findViewById(R.id.btnView)

        // Load the insert fragment by default on startup
        loadInsertFragment()

        // Set click listeners for switching fragments
        btnAdd.setOnClickListener {
            loadInsertFragment()
        }

        btnView.setOnClickListener {
            loadViewFragment()
        }
    }

    // Must be public so ViewRecordsFragment can trigger navigation on "Update"
    fun loadInsertFragment() {
        val fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, insertRecordFragment).commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, insertRecordFragment).commit()
        }
    }

    private fun loadViewFragment() {
        val fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, viewRecordsFragment).commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, viewRecordsFragment).commit()
        }
    }
}