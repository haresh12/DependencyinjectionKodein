package com.example.dependencyinjectionkodein.data.db

class DatabaseFakeimpl : Database
{
    override val quoteDao: QuoteDao =QuoteDaoFakeimpl()


}
