package com.example.fashionshop.features.favorite.domain

data class Product(
    val id: Int,
    val name: String,
    val shortDescription: String,
    val imageUri: String,
    val price: Double,
)
