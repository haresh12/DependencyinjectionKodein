package com.example.dependencyinjectionkodein.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dependencyinjectionkodein.data.model.Qoute

class QuoteDaoFakeimpl : QuoteDao {
    private val quoteList = mutableListOf<Qoute>()
    private val qoutes = MutableLiveData<List<Qoute>>()

    init {
        qoutes.value = quoteList
    }

    override fun addQuote(quote: Qoute) {
        quoteList.add(quote)
        qoutes.value = quoteList
    }

    override fun getQuote() = qoutes as LiveData<List<Qoute>>


}
