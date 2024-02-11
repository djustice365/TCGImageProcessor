package org.justice.tcgImageProcessor.model

data class CardData(
    val name: String,
    val edition: String,
    val number: String,
    val productionNumber: String,
    val base: String,
    val lowPrice: String,
    val highPrice: String
)
