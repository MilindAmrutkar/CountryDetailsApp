package com.backtocoding.countrydetailsapp.domain.usecases

import com.backtocoding.countrydetailsapp.common.Resource
import com.backtocoding.countrydetailsapp.domain.model.CountryDetails
import com.backtocoding.countrydetailsapp.domain.repository.CountryRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCountryDetailsUseCase(private val countryRepo: CountryRepo) {
    operator fun invoke(countryName: String): Flow<Resource<CountryDetails>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = countryRepo.getCountryDetails(countryName = countryName)))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}