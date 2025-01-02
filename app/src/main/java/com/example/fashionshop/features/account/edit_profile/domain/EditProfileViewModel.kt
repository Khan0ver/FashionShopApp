package com.example.fashionshop.features.account.edit_profile.domain

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.fashionshop.features.account.edit_profile.view.Coordinates
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor() : ViewModel() {
    private val _coordinates = MutableStateFlow(Coordinates(0.0, 0.0))
    var coordinates: StateFlow<Coordinates> = _coordinates

    @SuppressLint("MissingPermission")
    fun getLocation(launcher: FusedLocationProviderClient) {
        launcher.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                _coordinates.value = Coordinates(location.latitude, location.longitude)
            }
        }.addOnFailureListener { error ->
            Log.e("error", error.toString())
        }
    }
}