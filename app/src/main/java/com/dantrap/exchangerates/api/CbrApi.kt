package com.dantrap.exchangerates.api

import com.dantrap.exchangerates.model.CurrencyListResponse
import retrofit2.Response
import retrofit2.http.GET

interface CbrApi {
    @GET("daily_json.js")
    suspend fun getCurrency(): Response<CurrencyListResponse>
}