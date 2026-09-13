package com.example.madd_lab_04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private val todoList: MutableList<TodoItem>,
    private val onEditClick: (TodoItem) -> Unit,
    private val onDeleteClick: (TodoItem) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val tvTodoTitle: TextView =
            itemView.findViewById(R.id.tvTodoTitle)

        val btnEdit: Button =
            itemView.findViewById(R.id.btnEdit)

        val btnDelete: Button =
            itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodoViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_todo,
                parent,
                false
            )

        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: TodoViewHolder,
        position: Int
    ) {

        val todo = todoList[position]

        holder.tvTodoTitle.text = todo.title

        holder.btnEdit.setOnClickListener {

            onEditClick(todo)
        }

        holder.btnDelete.setOnClickListener {

            onDeleteClick(todo)
        }
    }

    override fun getItemCount(): Int {

        return todoList.size
    }

    fun updateData(newTodos: List<TodoItem>) {

        todoList.clear()

        todoList.addAll(newTodos)

        notifyDataSetChanged()
    }
}