package com.dantrap.exchangerates

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dantrap.exchangerates.model.CurrencyListResponse
import com.dantrap.exchangerates.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val currencyResponse: MutableLiveData<Response<CurrencyListResponse>> = MutableLiveData()

    fun getCurrency() {
        viewModelScope.launch {
            val response = repository.getCurrency()
            currencyResponse.value = response
        }
    }
}