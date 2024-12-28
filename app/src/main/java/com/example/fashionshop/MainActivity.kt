package com.example.fashionshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.fashionshop.features.auth.view.LoginScreen
import com.example.fashionshop.ui.theme.FashionShopTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val homeViewModel = ViewModelProvider(this)[HomeViewModel::class]
//        val homeViewModel: HomeViewModel by viewModels()

        enableEdgeToEdge()
        setContent {
            FashionShopTheme {
                LoginScreen()
                //HomeScreen(homeViewModel)
            }
        }
    }
}