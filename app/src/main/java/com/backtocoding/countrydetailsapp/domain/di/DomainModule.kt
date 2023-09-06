package com.backtocoding.countrydetailsapp.domain.di

import com.backtocoding.countrydetailsapp.domain.repository.CountryRepo
import com.backtocoding.countrydetailsapp.domain.usecases.GetCountryDetailsUseCase
import com.backtocoding.countrydetailsapp.domain.usecases.GetCountryListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {
    @Provides
    fun provideGetCountryListUseCase(countryRepo: CountryRepo): GetCountryListUseCase {
        return GetCountryListUseCase(countryRepo = countryRepo)
    }

    @Provides
    fun provideGetCountryDetailsUseCase(countryRepo: CountryRepo): GetCountryDetailsUseCase {
        return GetCountryDetailsUseCase(countryRepo = countryRepo)
    }
}