package com.example.dependencyinjectionkodein.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dependencyinjectionkodein.data.Repository.QuoteRepository

class QuoteViewModelFactory(private val quoteRepository: QuoteRepository) :ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QouteViewModel(quoteRepository) as T
    }
}
