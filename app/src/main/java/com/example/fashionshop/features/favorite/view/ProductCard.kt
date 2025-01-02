package com.example.fashionshop.features.favorite.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.size.Size.Companion.ORIGINAL

@Composable
fun ProductCard(productInfo: ProductInfo) {
    val painter1 = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(productInfo.imageUri)
            .size(ORIGINAL)
            .build(),
    )

    Card(
        modifier = Modifier
            .wrapContentSize(align = Alignment.Center)
            .fillMaxWidth(0.9f)
            .clickable {
                //TODO navigation
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        shape = RectangleShape,
        colors = CardColors(
            containerColor = Color.White,
            Color.Black,
            Color.Red,
            Color.LightGray
        ),
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                painter = painter1,
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
            )

            Text(
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.Start),
                style = MaterialTheme.typography.titleMedium,
                text = productInfo.name,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 4.dp),
                style = MaterialTheme.typography.bodySmall,
                text = productInfo.shortDescription
            )
        }
    }
}