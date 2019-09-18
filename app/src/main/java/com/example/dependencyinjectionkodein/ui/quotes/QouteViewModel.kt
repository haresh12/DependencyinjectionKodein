package com.example.dependencyinjectionkodein.ui.quotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dependencyinjectionkodein.data.Repository.QuoteRepository
import com.example.dependencyinjectionkodein.data.model.Qoute

class QouteViewModel(private val qoutes: QuoteRepository) : ViewModel() {

    fun addQuote(qoute: Qoute) {
        qoutes.addQuote(qoute)
    }


    fun getQuote() = qoutes.getQuote()  

}