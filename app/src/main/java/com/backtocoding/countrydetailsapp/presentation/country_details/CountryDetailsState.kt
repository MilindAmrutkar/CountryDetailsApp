package com.backtocoding.countrydetailsapp.presentation.country_details

import com.backtocoding.countrydetailsapp.domain.model.CountryDetails

data class CountryDetailsState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: CountryDetails? = null
)
