package com.example.fashionshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fashionshop.features.account.ProfileNavigation
import com.example.fashionshop.features.menu.MenuScreen
import com.example.fashionshop.ui.theme.FashionShopTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            FashionShopTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "profile"
                ) {
                    composable("menu") {
                        MenuScreen(navController)
                    }
                    composable("profile"){
                        ProfileNavigation(navController)
                    }
                }
            }
        }
    }
}