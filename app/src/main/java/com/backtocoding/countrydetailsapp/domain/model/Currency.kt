package com.backtocoding.countrydetailsapp.domain.model

data class Currency(
    val code: String,
    val compare: List<Compare>,
    val name: String,
    val rate: String,
    val symbol: Any
)