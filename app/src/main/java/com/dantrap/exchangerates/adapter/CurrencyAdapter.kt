package com.dantrap.exchangerates.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dantrap.exchangerates.R
import com.dantrap.exchangerates.databinding.ItemCurrencyBinding
import com.dantrap.exchangerates.model.CurrencyItem
import com.dantrap.exchangerates.model.CurrencyResponse
import com.dantrap.exchangerates.utils.Constants.Companion.currencyName
class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private var currencyResponse = CurrencyResponse()

    inner class CurrencyViewHolder(val binding: ItemCurrencyBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyAdapter.CurrencyViewHolder {
        return CurrencyViewHolder(ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CurrencyAdapter.CurrencyViewHolder, position: Int) {
        holder.binding.txtCharCode.text = currencyResponse.currency[currencyName[position]]?.charCode
        holder.binding.txtName.text = currencyResponse.currency[currencyName[position]]?.name
        holder.binding.txtNominal.text = currencyResponse.currency[currencyName[position]]?.nominal.toString()
        holder.binding.txtValue.text = currencyResponse.currency[currencyName[position]]?.value.toString()
    }

    override fun getItemCount(): Int = currencyName.size

    fun setData(newList: CurrencyResponse) {
        currencyResponse = newList
        notifyDataSetChanged()
    }
}