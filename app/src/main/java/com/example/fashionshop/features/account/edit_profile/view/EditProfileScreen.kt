package com.example.fashionshop.features.account.edit_profile.view

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Build
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.fashionshop.features.account.edit_profile.domain.EditProfileViewModel
import com.google.android.gms.location.LocationServices

@SuppressLint("MissingPermission")
@Composable
fun EditProfileScreen() {
    val viewModel = hiltViewModel<EditProfileViewModel>()
    val context = LocalContext.current
    val locationManager = LocationServices.getFusedLocationProviderClient(context)
    val coordinates = viewModel.coordinates.collectAsStateWithLifecycle()

    val geocoder = Geocoder(context)

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            Log.d("ExampleScreen", "PERMISSION GRANTED")
            viewModel.getLocation(locationManager)
        } else {
            Log.d("ExampleScreen", "PERMISSION DENIED")
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (isHavePermissionsForLocation(context)) {
                    viewModel.getLocation(locationManager)
                } else {
                    launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                    launcher.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
                }
            } else {
                viewModel.getLocation(locationManager)
            }
        }) {
            Text("Know ur location button")
        }

        if (coordinates.value == Coordinates(0.0, 0.0)) {
            Text("No data about ur location")
        } else {
            var address = geocoder.getFromLocation(coordinates.value.latitude, coordinates.value.longitude, 1)
            Text(address?.get(0)?.countryName.toString() + address?.get(0)?.locality.toString())
        }
    }
}

fun isHavePermissionsForLocation(context: Context): Boolean {
    return (
            ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED
                    && ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
                    == PackageManager.PERMISSION_GRANTED
            )
}

data class Coordinates(
    val latitude: Double,
    val longitude: Double,
)