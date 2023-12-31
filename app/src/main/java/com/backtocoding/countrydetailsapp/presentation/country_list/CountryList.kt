package com.backtocoding.countrydetailsapp.presentation.country_list

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.backtocoding.countrydetailsapp.domain.model.Country

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryListScreen(
    navController: NavController,
    viewModel: CountryListViewModel = hiltViewModel()
) {

    val res = viewModel.list.value

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "Country List")
        })
    }) {
        if (res.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        if (res.error.isNotBlank()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = res.error.toString())
            }
        }

        res.data?.let {
            LazyColumn {
                items(it) {
                    CountryListItem(country = it) {
                        navController.navigate("country_details/${it}")
                    }
                }
            }
        }
    }
}

@Composable
fun CountryListItem(country: Country, onClick: (String) -> Unit) {
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .clickable {
            onClick.invoke(country.name)
        }) {
        Text(
            text = country.name,
            modifier = Modifier.padding(8.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp
            )
        )
    }
}