package com.example.fashionshop.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
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
import androidx.navigation.NavController
import com.example.fashionshop.R

@Composable
fun DefaultBottomAppBar(navController: NavController) {
    BottomAppBar(
        modifier = Modifier.height(96.dp),
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                IconButton(onClick = {}) {
                    Icon(Icons.Outlined.Home, null)
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Outlined.Search, null)
                }
                TextButton(onClick = {
                    navController.navigate("menu")
                }) {
                    Text(
                        text = stringResource(R.string.menu),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Outlined.ShoppingCart, null)
                }
                IconButton(onClick = {
                    navController.navigate("profile")
                }) {
                    Icon(Icons.Outlined.AccountBox, null)
                }
            }
        }
    )
}