package com.example.tutorial04

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tutorial04.database.MyDatabase
import com.example.tutorial04.database.entities.MyTable
import com.example.tutorial04.database.repository.MyTableRepositories
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityData : ViewModel() {
    private val _listMyTable = MutableLiveData<List<MyTable>>()
    private val _insertSuccess = MutableLiveData<Boolean>().apply { value = false }
    private val _selectedItem = MutableLiveData<MyTable?>()

    val listMyTable: LiveData<List<MyTable>> = _listMyTable
    val insertSuccess: LiveData<Boolean> = _insertSuccess
    val selectedItem: LiveData<MyTable?> = _selectedItem

    fun loadData(context: Context) {
        val repository = MyTableRepositories(MyDatabase.getInstance(context))
        CoroutineScope(Dispatchers.IO).launch {
            _listMyTable.postValue(repository.getAll())
        }
    }

    fun insertData(context: Context, myTable: MyTable) {
        val repository = MyTableRepositories(MyDatabase.getInstance(context))
        CoroutineScope(Dispatchers.IO).launch {
            repository.insert(myTable)
        }
    }

    fun updateData(context: Context, myTable: MyTable) {
        val repository = MyTableRepositories(MyDatabase.getInstance(context))
        CoroutineScope(Dispatchers.IO).launch {
            repository.update(myTable)
            loadData(context)
        }
    }

    fun deleteData(context: Context, myTable: MyTable) {
        val repository = MyTableRepositories(MyDatabase.getInstance(context))
        CoroutineScope(Dispatchers.IO).launch {
            repository.delete(myTable)
            loadData(context)
        }
    }

    fun setInsertSuccess(value: Boolean) {
        _insertSuccess.value = value
    }

    fun selectItem(item: MyTable?) {
        _selectedItem.value = item
    }
}