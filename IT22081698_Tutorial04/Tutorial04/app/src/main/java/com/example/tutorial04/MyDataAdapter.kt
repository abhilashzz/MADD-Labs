package com.example.tutorial04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tutorial04.database.entities.MyTable

// ViewHolder class holding references to item UI components
class MyDataVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvItemName: TextView = itemView.findViewById(R.id.tvItemName)
    val btnUpdateItem: Button = itemView.findViewById(R.id.btnUpdateItem)
    val btnDeleteItem: Button = itemView.findViewById(R.id.btnDeleteItem)
}

// Adapter class managing data binding and click callbacks
class MyDataAdapter(
    private val data: List<MyTable>,
    private val onUpdateClick: (MyTable) -> Unit,
    private val onDeleteClick: (MyTable) -> Unit
) : RecyclerView.Adapter<MyDataVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDataVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_layout, parent, false)
        return MyDataVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyDataVH, position: Int) {
        val singleData = data[position]
        holder.tvItemName.text = singleData.name

        // Callback for update button
        holder.btnUpdateItem.setOnClickListener {
            onUpdateClick(singleData)
        }

        // Callback for delete button
        holder.btnDeleteItem.setOnClickListener {
            onDeleteClick(singleData)
        }
    }
}