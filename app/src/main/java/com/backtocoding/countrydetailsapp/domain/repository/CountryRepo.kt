package com.backtocoding.countrydetailsapp.domain.repository

import com.backtocoding.countrydetailsapp.domain.model.Country
import com.backtocoding.countrydetailsapp.domain.model.CountryDetails

interface CountryRepo {
    suspend fun getCountryList(): List<Country>
    suspend fun getCountryDetails(countryName: String): CountryDetails
}