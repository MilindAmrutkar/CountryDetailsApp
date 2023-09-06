package com.backtocoding.countrydetailsapp.data.di

import com.backtocoding.countrydetailsapp.data.network.ApiService
import com.backtocoding.countrydetailsapp.data.repository.CountryRepoImpl
import com.backtocoding.countrydetailsapp.domain.repository.CountryRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl("https://travelbriefing.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideCountryRepo(apiService: ApiService): CountryRepo {
        return CountryRepoImpl(apiService)
    }
}