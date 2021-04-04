package com.dantrap.exchangerates.repository

import com.dantrap.exchangerates.api.RetrofitInstance
import com.dantrap.exchangerates.model.CurrencyListResponse
import retrofit2.Response

class Repository {

    suspend fun getCurrency(): Response<CurrencyListResponse> = RetrofitInstance.api.getCurrency()

}