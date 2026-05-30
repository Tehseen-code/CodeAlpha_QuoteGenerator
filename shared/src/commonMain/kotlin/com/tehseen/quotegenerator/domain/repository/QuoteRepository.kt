package com.tehseen.quotegenerator.domain.repository

import com.tehseen.quotegenerator.data.model.Quote

interface QuoteRepository {
    suspend fun getRandomQuote(): Result<Quote>
}