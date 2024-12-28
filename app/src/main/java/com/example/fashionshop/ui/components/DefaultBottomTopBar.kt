package com.example.fashionshop.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.fashionshop.R

@Composable
fun DefaultBottomAppBar() {
    BottomAppBar(
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Home, null)
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Search, null)
                }
                TextButton(onClick = {}) {
                    Text(
                        text = stringResource(R.string.menu),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.ShoppingCart, null)
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.AccountBox, null)
                }
            }
        }
    )
}