package com.backtocoding.countrydetailsapp.presentation.country_details.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.backtocoding.countrydetailsapp.domain.model.Compare
import com.backtocoding.countrydetailsapp.domain.model.CountryDetails
import com.backtocoding.countrydetailsapp.domain.model.Currency
import com.backtocoding.countrydetailsapp.domain.model.Language
import com.backtocoding.countrydetailsapp.domain.model.Neighbor
import com.backtocoding.countrydetailsapp.domain.model.Vaccination

@Composable
fun CountryHeader(countryDetails: CountryDetails) {
    Text(
        text = countryDetails.names.full,
        style = TextStyle(color = Color.Black, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold),
        modifier = Modifier.padding(12.dp)
    )

    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        Text(
            text = "Continent: " + countryDetails.names.continent,
            style = TextStyle(Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Medium),
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "TimeZone: " + countryDetails.timezone.name,
            style = TextStyle(Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Medium),
            modifier = Modifier.padding(8.dp)
        )
    }

    Text(
        text = "Telephone",
        style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold),
        modifier = Modifier.padding(12.dp)
    )

    Text(
        text = "Ambulance: ${countryDetails.telephone.ambulance}",
        style = TextStyle(
            color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Normal
        ), modifier = Modifier.padding(horizontal = 12.dp)
    )

    Text(
        text = "Calling Code: ${countryDetails.telephone.calling_code}",
        style = TextStyle(
            color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Normal
        ), modifier = Modifier.padding(horizontal = 12.dp)
    )

    Text(
        text = "Police: ${countryDetails.telephone.police}",
        style = TextStyle(
            color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Normal
        ), modifier = Modifier.padding(horizontal = 12.dp)
    )

    Text(
        text = "Fire: ${countryDetails.telephone.fire}",
        style = TextStyle(
            color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Normal
        ), modifier = Modifier.padding(horizontal = 12.dp)
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LanguageComp(language: List<Language>) {
    Text(
        text = "Languages",
        style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold),
        modifier = Modifier.padding(12.dp)
    )

    FlowRow {
        language.forEach {
            LanguageItem(language = it)
        }
    }
}

@Composable
fun LanguageItem(language: Language) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .wrapContentSize(),
        border = BorderStroke(1.dp, color = Color.Blue),
        shape = RoundedCornerShape(100.dp)
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = language.language,
            style = TextStyle(
                color = Color.Black, fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Composable
fun VaccinationsComp(vaccination: List<Vaccination>) {
    Text(
        text = "Vaccinations",
        style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold),
        modifier = Modifier.padding(12.dp)
    )

    LazyRow {
        items(vaccination) {
            VaccinationItem(vaccination = it)
        }
    }
}

@Composable
fun VaccinationItem(vaccination: Vaccination) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(12.dp), shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = vaccination.name,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                textDecoration = TextDecoration.Underline
            )
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .width(150.dp),
                text = vaccination.message,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun CurrencyComp(currency: Currency) {
    Text(
        text = "Currency",
        style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold),
        modifier = Modifier.padding(12.dp)
    )

    LazyRow {
        items(currency.compare) {
            CurrencyItem(currency = currency, compare = it)
        }
    }
}

@Composable
fun CurrencyItem(currency: Currency, compare: Compare) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(12.dp),
        shape = RoundedCornerShape(8.dp),
        colors = if (currency.rate.toDouble() >= compare.rate.toDouble()) {
            CardDefaults.cardColors(Color.Gray)
        } else {
            CardDefaults.cardColors(Color.Red)
        }
    ) {
        Column(
            modifier = Modifier.padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = compare.name, style = TextStyle(Color.Black, fontSize = 14.sp),
                modifier = Modifier.padding(4.dp)
            )

            Text(
                text = "1$ = " + compare.rate, style = TextStyle(Color.Black, fontSize = 16.sp),
                modifier = Modifier.padding(4.dp)
            )

            Text(
                text = if (currency.rate.toDouble() >= compare.rate.toDouble()) {
                    "Low"
                } else {
                    "High"
                }, style = TextStyle(Color.Black, fontSize = 16.sp),
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun NeighborComp(list: List<Neighbor>) {
    Text(
        text = "Neighbor",
        style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold),
        modifier = Modifier.padding(12.dp)
    )

    LazyRow {
        items(list) {
            NeighborItem(neighbor = it)
        }
    }
}

@Composable
fun NeighborItem(neighbor: Neighbor) {

    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp)
    ) {

        Text(
            text = neighbor.name,
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.SemiBold),
            modifier = Modifier.padding(4.dp)
        )
    }

}