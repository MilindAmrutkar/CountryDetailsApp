package com.backtocoding.countrydetailsapp.data.repository

import com.backtocoding.countrydetailsapp.common.toDomain
import com.backtocoding.countrydetailsapp.data.network.ApiService
import com.backtocoding.countrydetailsapp.domain.model.Country
import com.backtocoding.countrydetailsapp.domain.model.CountryDetails
import com.backtocoding.countrydetailsapp.domain.repository.CountryRepo

class CountryRepoImpl(private val apiService: ApiService) : CountryRepo {
    override suspend fun getCountryList(): List<Country> {
        return apiService.getCountryList().map {
            it.toDomain()
        }
    }

    override suspend fun getCountryDetails(countryName: String): CountryDetails {
        return apiService.getCountryDetails(countryName = countryName).toDomain()
    }
}