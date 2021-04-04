package com.dantrap.exchangerates.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class CurrencyListResponse(
        @SerializedName("Date")
        val date: String,

        @SerializedName("PreviousDate")
        val previousDate: String,

        @SerializedName("PreviousURL")
        val previousUrl: String,

        @SerializedName("Timestamp")
        val timestamp: String,

        @SerializedName("Valute")
        val currency: CurrencyListValutes)


data class CurrencyListValutes(
        @SerializedName("USD")
        val usd: CurrencyListItem,

        @SerializedName("EUR")
        val eur: CurrencyListItem)