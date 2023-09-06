package com.backtocoding.countrydetailsapp.presentation.country_details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.backtocoding.countrydetailsapp.presentation.country_details.components.CountryHeader
import com.backtocoding.countrydetailsapp.presentation.country_details.components.CurrencyComp
import com.backtocoding.countrydetailsapp.presentation.country_details.components.LanguageComp
import com.backtocoding.countrydetailsapp.presentation.country_details.components.NeighborComp
import com.backtocoding.countrydetailsapp.presentation.country_details.components.VaccinationsComp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryDetails(countryName: String, viewModel: CountryDetailsViewModel = hiltViewModel()) {
    Scaffold(topBar = { TopAppBar(title = { Text(text = countryName) }) }) {
        val res = viewModel.countryDetails.value

        if (res.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        if (res.error.isNotBlank()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = res.error)
            }
        }

        res.data?.let {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                CountryHeader(it)
                LanguageComp(it.language)
                VaccinationsComp(it.vaccinations)
                CurrencyComp(it.currency)
                NeighborComp(it.neighbors)
            }
        }
    }
}