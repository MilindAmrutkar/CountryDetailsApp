package com.backtocoding.countrydetailsapp.presentation.country_list

import com.backtocoding.countrydetailsapp.domain.model.Country

data class CountryListState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Country>? = null
)
