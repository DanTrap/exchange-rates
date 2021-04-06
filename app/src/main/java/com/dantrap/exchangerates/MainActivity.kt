package com.dantrap.exchangerates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dantrap.exchangerates.adapter.CurrencyAdapter
import com.dantrap.exchangerates.databinding.ActivityMainBinding
import com.dantrap.exchangerates.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel
    private val currencyAdapter by lazy { CurrencyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCurrency()

        setupRecyclerView()

        viewModel.currencyResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let { currencyAdapter.setData(it) }
            } else {
                Log.d("Fuck", response.code().toString())
            }
        })
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = currencyAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}