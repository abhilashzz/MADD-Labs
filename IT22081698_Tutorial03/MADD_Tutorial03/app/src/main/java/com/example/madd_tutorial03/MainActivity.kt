package com.example.madd_tutorial03 // Keep your package name

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    // Fragment objects
    val walkingFragment = WalkingFragment()
    val cyclingFragment = CyclingFragment()
    val drivingFragment = DrivingFragment()

    val menuFragment = MenuFragment()

    private lateinit var viewModel: MainActivityData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadMenu()

        // Retrieve the ViewModel
        viewModel = ViewModelProvider(this).get(MainActivityData::class.java)

        // Observe the value and swap fragments based on the number
        viewModel.clickedvalue.observe(this, Observer {
            if (it == 1) {
                walk()
            }
            if (it == 2) {
                cycle()
            }
            if (it == 3) {
                drive()
            }
        })
    }

    private fun loadMenu() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_menu)
        if(fragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_menu, menuFragment).commit()
        }
    }

    // --- Functions to load the specific fragments ---
    private fun walk() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, walkingFragment).commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, walkingFragment).commit()
        }
    }

    private fun cycle() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, cyclingFragment).commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, cyclingFragment).commit()
        }
    }

    private fun drive() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, drivingFragment).commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, drivingFragment).commit()
        }
    }
}