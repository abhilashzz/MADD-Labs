package com.example.madd_lab_04

object TodoRepository {

    private val todoList = mutableListOf<TodoItem>()

    private var nextId = 1

    fun addTodo(title: String) {
        val todo = TodoItem(
            id = nextId,
            title = title
        )

        todoList.add(todo)

        nextId++
    }

    fun getTodos(): List<TodoItem> {
        return todoList.toList()
    }

    fun updateTodo(id: Int, newTitle: String) {
        val todo = todoList.find {
            it.id == id
        }

        todo?.title = newTitle
    }

    fun deleteTodo(id: Int) {
        todoList.removeAll {
            it.id == id
        }
    }
}