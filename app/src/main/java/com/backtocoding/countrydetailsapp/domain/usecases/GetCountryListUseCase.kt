package com.backtocoding.countrydetailsapp.domain.usecases

import com.backtocoding.countrydetailsapp.common.Resource
import com.backtocoding.countrydetailsapp.domain.model.Country
import com.backtocoding.countrydetailsapp.domain.repository.CountryRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCountryListUseCase(private val countryRepo: CountryRepo) {
    operator fun invoke(): Flow<Resource<List<Country>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = countryRepo.getCountryList()))
        } catch (e: Exception) {
            emit(Resource.Error(message = null))
        }
    }.flowOn(Dispatchers.IO)
}