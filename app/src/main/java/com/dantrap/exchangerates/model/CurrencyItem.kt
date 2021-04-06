package com.dantrap.exchangerates.model

import com.google.gson.annotations.SerializedName

data class CurrencyItem(
    @SerializedName("ID")
    val id: String,

    @SerializedName("NumCode")
    val numCode: Int,

    @SerializedName("CharCode")
    val charCode: String,

    @SerializedName("Nominal")
    val nominal: Int,

    @SerializedName("Name")
    val name: String,

    @SerializedName("Value")
    val value: Double,

    @SerializedName("Previous")
    val previousValue: Double)