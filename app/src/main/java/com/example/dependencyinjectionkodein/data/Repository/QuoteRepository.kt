package com.example.dependencyinjectionkodein.data.Repository

import androidx.lifecycle.LiveData
import com.example.dependencyinjectionkodein.data.model.Qoute

interface QuoteRepository {
    fun addQuote(quote : Qoute)
    fun getQuote() : LiveData<List<Qoute>>
}