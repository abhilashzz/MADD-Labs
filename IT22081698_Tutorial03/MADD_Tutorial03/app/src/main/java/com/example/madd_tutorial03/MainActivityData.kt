package com.example.madd_tutorial03
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityData: ViewModel() {
    private val _clickedValue = MutableLiveData<Int>().apply { value = 0 }
    val clickedvalue: LiveData<Int> = _clickedValue

    fun setCountValue(value: Int) {
        _clickedValue.value = value
    }
}
