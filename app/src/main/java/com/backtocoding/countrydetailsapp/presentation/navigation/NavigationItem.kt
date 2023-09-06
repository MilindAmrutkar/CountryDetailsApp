package com.backtocoding.countrydetailsapp.presentation.navigation

sealed class NavigationItem(val route: String) {
    object CountryListNavigationItem : NavigationItem("country_list")
    object CountryDetailsNavigationItem : NavigationItem("country_details/{country_name}")
}
