package com.example.fashionshop.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackArrowTopBar(){
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
            }
        },
        title = {}
    )
}