package com.daviddam.modelviewmodeldavidgelmacorral

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import viewmodel.QuoteViewModel
import androidx.appcompat.app.AppCompatActivity

import com.daviddam.modelviewmodeldavidgelmacorral.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })

        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }

        quoteViewModel.randomQuote()

    }
}