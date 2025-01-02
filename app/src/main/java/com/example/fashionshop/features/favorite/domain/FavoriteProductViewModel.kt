package com.example.fashionshop.features.favorite.domain

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fashionshop.common.NetworkResponse
import com.example.fashionshop.features.favorite.data.FavoriteProductRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteProductViewModel @Inject constructor(
    private val repository: FavoriteProductRepository
) : ViewModel() {
    private var _favoriteProducts = MutableStateFlow<List<Product>>(emptyList())
    val favoriteProducts: StateFlow<List<Product>> = _favoriteProducts

    fun getAllFavoriteProducts() {
        viewModelScope.launch {
            val response =
                repository.getAllFavoriteProductsById(Firebase.auth?.currentUser?.uid.toString())
            if (response is NetworkResponse.Success) {
                Log.i("Info", Firebase.auth.currentUser?.uid.toString())
                Log.i("Info", response.toString())
            }
        }
    }
}