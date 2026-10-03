package com.example.tutorial04

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tutorial04.database.entities.MyTable

class InsertRecordFragment : Fragment() {

    private lateinit var viewModel: MainActivityData
    private var editingItem: MyTable? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_insert_record, container, false)
        val tvTitle: TextView = rootView.findViewById(R.id.tvTitle)
        val edtName: EditText = rootView.findViewById(R.id.edtName)
        val edtDOB: EditText = rootView.findViewById(R.id.edtDOB)
        val btnUpdate: Button = rootView.findViewById(R.id.btnUpdate)
        val btnInsert: Button = rootView.findViewById(R.id.btnInsertRecord)

        viewModel = ViewModelProvider(requireActivity())[MainActivityData::class.java]

        // Observe if an item is selected for editing
        viewModel.selectedItem.observe(viewLifecycleOwner) { item ->
            if (item != null) {
                editingItem = item
                tvTitle.text = "Update Record"
                edtName.setText(item.name)
                edtDOB.setText(item.dateOfBirth)
                btnUpdate.isEnabled = true
                btnInsert.isEnabled = false
            } else {
                tvTitle.text = "Insert Record"
                btnUpdate.isEnabled = false
                btnInsert.isEnabled = true
            }
        }

        btnInsert.setOnClickListener {
            val data = MyTable(edtName.text.toString(), edtDOB.text.toString())
            insertData(viewModel, requireContext(), data)
            edtName.text.clear()
            edtDOB.text.clear()
            Toast.makeText(requireContext(), "Record Saved", Toast.LENGTH_SHORT).show()
        }

        btnUpdate.setOnClickListener {
            editingItem?.let {
                it.name = edtName.text.toString()
                it.dateOfBirth = edtDOB.text.toString()
                viewModel.updateData(requireContext(), it)
                viewModel.selectItem(null)
                edtName.text.clear()
                edtDOB.text.clear()
                Toast.makeText(requireContext(), "Record Updated", Toast.LENGTH_SHORT).show()
            }
        }

        return rootView
    }

    private fun insertData(viewModel: MainActivityData, context: Context, myTable: MyTable) {
        try {
            viewModel.insertData(context, myTable)
            viewModel.setInsertSuccess(true)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}