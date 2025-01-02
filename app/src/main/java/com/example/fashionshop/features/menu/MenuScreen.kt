package com.example.fashionshop.features.menu

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuScreen(mainNavController: NavController){
    Text("Menu Screen", modifier = Modifier.fillMaxSize().padding(120.dp))
}