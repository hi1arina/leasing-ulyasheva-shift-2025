package com.example.leasing.cars_catalog.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.leasing.cars_catalog.domain.entity.Car
import com.example.leasing.cars_catalog.presentation.CarsCatalogState
import com.example.leasing.cars_catalog.presentation.SearchState

@Composable
fun CarsCatalogContent(state: CarsCatalogState.Content, onSearchValueChange: (String) -> Unit) {

    CatalogContent(
        searchValue = state.searchState.search, onSearchValueChange = onSearchValueChange
    )
    when (val searchState = state.searchState) {
        is SearchState.Found -> CarsCatalogList(searchState.cars)
        is SearchState.NotFound -> {}
    }

}

@Composable
fun CarsCatalogList(cars: List<Car> = emptyList()) {

    LazyColumn(
        modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(cars) { car ->
            CarItem(car = car)
        }
    }
}

@Composable
fun CatalogContent(
    searchValue: String, onSearchValueChange: (String) -> Unit
) {
    Column {
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Автомобили",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Поиск", style = MaterialTheme.typography.bodyMedium)
        OutlinedTextField(
            value = searchValue,
            onValueChange = onSearchValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Поиск") },
            shape = RoundedCornerShape(8.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Даты аренды", style = MaterialTheme.typography.bodyMedium)
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            trailingIcon = {
                Icon(Icons.Default.DateRange, contentDescription = "Дата")
            })

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("Фильтры")
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

const val BASE_IMAGE_URL = "https://shift-intensive.ru/api"

@Composable
fun CarItem(car: Car) {
    Row(
        modifier = Modifier
            .height(116.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AsyncImage(
            model = BASE_IMAGE_URL + car.media.firstOrNull()?.url,
            contentDescription = null,
            modifier = Modifier
                .width(152.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Fit
        )

        Column(
            modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = car.name,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
            )
            Text(
                text = car.transmission.name, style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "${car.price} ₽",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
            )

            Text("текст") // временное поле
        }
    }
}