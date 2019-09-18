package com.example.dependencyinjectionkodein.data.db

import androidx.lifecycle.LiveData
import com.example.dependencyinjectionkodein.data.model.Qoute

interface QuoteDao {

    fun addQuote(quote :Qoute)
    fun getQuote() :LiveData<List<Qoute>>
}