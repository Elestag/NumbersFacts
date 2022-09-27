package com.ostapenko.android.retrofitpluscoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NumbersViewModel : ViewModel() {

    private val numbersRepository = NumbersRepository.get()

    //var numbersLiveData: MutableLiveData<NumbersData> = MutableLiveData()
    var numbersLiveData: MutableLiveData<List<NumbersData>> = MutableLiveData()
    var currentNumber: String = ""
    var numbersListData: List<NumbersData> = listOf()

    fun getNumberQuery(number: String) {
        viewModelScope.launch {
            val response = numbersRepository.getQuery(number)
            numbersLiveData.value = listOf(response)
            numbersListData = numbersListData.plus(response)
        }
    }


    fun addNumber(numbersData: NumbersData) {
        viewModelScope.launch {
            numbersRepository.addNumber(numbersData)
        }
    }

    fun getNumbers() {
        viewModelScope.launch {
            numbersListData = numbersRepository.getNumbers()
        }
    }

    fun deleteAllNumbers() {
        viewModelScope.launch {
            numbersRepository.deleteAllNumbers()
        }
    }

}