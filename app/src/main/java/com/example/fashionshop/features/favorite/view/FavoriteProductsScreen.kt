package com.example.fashionshop.features.favorite.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fashionshop.features.favorite.domain.FavoriteProductViewModel

@Composable
fun FavoriteProductsScreen() {
    val viewModel = hiltViewModel<FavoriteProductViewModel>()

    Column {
        Button(onClick = { viewModel.getAllFavoriteProducts() }) {
            Text("Press me")
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(productInfoTestList) { product ->
                ProductCard(product)
            }
        }
    }
}