package com.example.fashionshop.features.account

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fashionshop.di.Paddings
import com.example.fashionshop.features.account.profile.view.AccountScreen
import com.example.fashionshop.features.account.registration_and_login.view.LoginScreen
import com.example.fashionshop.features.account.registration_and_login.view.RegistrationScreen
import com.example.fashionshop.ui.components.BackArrowTopBar
import com.example.fashionshop.ui.components.DefaultBottomAppBar

@Composable
fun ProfileNavigation(mainNavController: NavController) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            BackArrowTopBar(navController)
        },
        bottomBar = {
            DefaultBottomAppBar(mainNavController)
        },
    ) { innerPadding ->
        Paddings.innerPadding = innerPadding
    }

    NavHost(
        navController = navController, startDestination = "profile"
    ) {
        composable("profile") {
            AccountScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("registration") {
            RegistrationScreen(navController)
        }
    }
}