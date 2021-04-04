package com.dantrap.exchangerates.api

import com.dantrap.exchangerates.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val api: CbrApi by lazy {
        retrofit.create(CbrApi::class.java)
    }

}