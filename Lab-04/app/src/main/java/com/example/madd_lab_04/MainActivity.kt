package com.example.madd_lab_04

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etTodo: EditText
    private lateinit var btnAddTodo: Button
    private lateinit var btnViewTodos: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        etTodo = findViewById(R.id.etTodo)
        btnAddTodo = findViewById(R.id.btnAddTodo)
        btnViewTodos = findViewById(R.id.btnViewTodos)

        btnAddTodo.setOnClickListener {

            addTodo()
        }

        btnViewTodos.setOnClickListener {

            val intent = Intent(
                this,
                TodoListActivity::class.java
            )

            startActivity(intent)
        }
    }

    private fun addTodo() {

        val todoText = etTodo.text
            .toString()
            .trim()

        if (todoText.isEmpty()) {

            etTodo.error = "Please enter a Todo item"

            etTodo.requestFocus()

            return
        }

        TodoRepository.addTodo(todoText)

        Toast.makeText(
            this,
            "Todo added successfully",
            Toast.LENGTH_SHORT
        ).show()

        etTodo.text.clear()
    }
}