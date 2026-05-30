package com.tehseen.quotegenerator.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Quote(
    val q: String, // The actual text of the quote
    val a: String, // Author name
    val h: String? = null // Optional HTML preview styling mapping string
)