package com.backtocoding.countrydetailsapp.data.model

data class CurrencyDTO(
    val code: String?,
    val compare: List<CompareDTO>?,
    val name: String?,
    val rate: String?,
    val symbol: String?
)