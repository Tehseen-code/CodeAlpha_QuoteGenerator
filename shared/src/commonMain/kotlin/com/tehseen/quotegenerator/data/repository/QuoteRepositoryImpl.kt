package com.tehseen.quotegenerator.data.repository

import com.tehseen.quotegenerator.core.network.KtorClient
import com.tehseen.quotegenerator.data.model.Quote
import com.tehseen.quotegenerator.domain.repository.QuoteRepository
import io.ktor.client.call.body
import io.ktor.client.request.get

class QuoteRepositoryImpl : QuoteRepository {
    override suspend fun getRandomQuote(): Result<Quote> {
        return try {
            // ZenQuotes API safely triggered
            val response: List<Quote> = KtorClient.instance.get("https://zenquotes.io/api/random").body()
            if (response.isNotEmpty()) {
                Result.success(response.first())
            } else {
                Result.failure(Exception("Empty API Response payload"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}