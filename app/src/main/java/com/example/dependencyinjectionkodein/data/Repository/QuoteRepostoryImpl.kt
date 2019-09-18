package com.example.dependencyinjectionkodein.data.Repository

import androidx.lifecycle.LiveData
import com.example.dependencyinjectionkodein.data.db.QuoteDao
import com.example.dependencyinjectionkodein.data.model.Qoute

class QuoteRepostoryImpl(private val quoteDao: QuoteDao) : QuoteRepository {
    override fun addQuote(quote: Qoute) {
        quoteDao.addQuote(quote)
    }

    override fun getQuote() = quoteDao.getQuote()

}