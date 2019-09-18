package com.example.dependencyinjectionkodein.ui

import android.app.Application
import com.example.dependencyinjectionkodein.data.Repository.QuoteRepository
import com.example.dependencyinjectionkodein.data.Repository.QuoteRepostoryImpl
import com.example.dependencyinjectionkodein.data.db.Database
import com.example.dependencyinjectionkodein.data.db.DatabaseFakeimpl
import com.example.dependencyinjectionkodein.data.db.QuoteDao
import com.example.dependencyinjectionkodein.data.db.QuoteDaoFakeimpl
import com.example.dependencyinjectionkodein.ui.quotes.QuoteViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QuotesApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        bind<Database>() with singleton { DatabaseFakeimpl() }
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository>() with singleton { QuoteRepostoryImpl(instance()) }
        bind() from provider { QuoteViewModelFactory(instance()) }
    }
}
