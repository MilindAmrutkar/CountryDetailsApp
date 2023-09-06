package com.backtocoding.countrydetailsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.backtocoding.countrydetailsapp.presentation.country_details.CountryDetails
import com.backtocoding.countrydetailsapp.presentation.country_list.CountryListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationItem.CountryListNavigationItem.route
    ) {
        composable(NavigationItem.CountryDetailsNavigationItem.route) {
            val countryName = it.arguments?.getString("country_name")
            CountryDetails(countryName = countryName.toString())
        }

        composable(NavigationItem.CountryListNavigationItem.route) {
            CountryListScreen(navController = navController)
        }
    }
}