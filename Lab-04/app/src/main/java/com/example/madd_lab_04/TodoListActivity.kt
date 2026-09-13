package com.example.madd_lab_04

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TodoListActivity : AppCompatActivity() {

    private lateinit var recyclerViewTodos: RecyclerView
    private lateinit var tvEmpty: TextView
    private lateinit var btnBackToAdd: Button

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_todo_list)

        recyclerViewTodos =
            findViewById(R.id.recyclerViewTodos)

        tvEmpty =
            findViewById(R.id.tvEmpty)

        btnBackToAdd =
            findViewById(R.id.btnBackToAdd)

        setupRecyclerView()

        btnBackToAdd.setOnClickListener {

            finish()
        }
    }

    private fun setupRecyclerView() {

        todoAdapter = TodoAdapter(
            mutableListOf(),

            onEditClick = { todo ->

                showEditDialog(todo)
            },

            onDeleteClick = { todo ->

                showDeleteDialog(todo)
            }
        )

        recyclerViewTodos.layoutManager =
            LinearLayoutManager(this)

        recyclerViewTodos.adapter =
            todoAdapter

        refreshTodoList()
    }

    private fun refreshTodoList() {

        val todos =
            TodoRepository.getTodos()

        todoAdapter.updateData(todos)

        if (todos.isEmpty()) {

            recyclerViewTodos.visibility =
                View.GONE

            tvEmpty.visibility =
                View.VISIBLE

        } else {

            recyclerViewTodos.visibility =
                View.VISIBLE

            tvEmpty.visibility =
                View.GONE
        }
    }

    private fun showEditDialog(
        todo: TodoItem
    ) {

        val editText = EditText(this)

        editText.setText(todo.title)

        editText.setSelection(
            editText.text.length
        )

        AlertDialog.Builder(this)
            .setTitle("Update Todo")
            .setMessage("Edit your Todo item")
            .setView(editText)

            .setPositiveButton(
                "Update"
            ) { _, _ ->

                val newTitle =
                    editText.text
                        .toString()
                        .trim()

                if (newTitle.isNotEmpty()) {

                    TodoRepository.updateTodo(
                        todo.id,
                        newTitle
                    )

                    refreshTodoList()

                    Toast.makeText(
                        this,
                        "Todo updated successfully",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    Toast.makeText(
                        this,
                        "Todo cannot be empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            .setNegativeButton(
                "Cancel",
                null
            )

            .show()
    }

    private fun showDeleteDialog(
        todo: TodoItem
    ) {

        AlertDialog.Builder(this)

            .setTitle("Delete Todo")

            .setMessage(
                "Are you sure you want to delete \"${todo.title}\"?"
            )

            .setPositiveButton(
                "Delete"
            ) { _, _ ->

                TodoRepository.deleteTodo(
                    todo.id
                )

                refreshTodoList()

                Toast.makeText(
                    this,
                    "Todo deleted successfully",
                    Toast.LENGTH_SHORT
                ).show()
            }

            .setNegativeButton(
                "Cancel",
                null
            )

            .show()
    }

    override fun onResume() {
        super.onResume()

        if (::todoAdapter.isInitialized) {

            refreshTodoList()
        }
    }
}