package com.dantrap.exchangerates.model

import com.google.gson.annotations.SerializedName

data class CurrencyResponse(
        @SerializedName("Date")
        val date: String = "",

        @SerializedName("PreviousDate")
        val previousDate: String = "",

        @SerializedName("PreviousURL")
        val previousUrl: String = "",

        @SerializedName("Timestamp")
        val timestamp: String = "",

        @SerializedName("Valute")
        val currency: HashMap<String, CurrencyItem> = hashMapOf())
