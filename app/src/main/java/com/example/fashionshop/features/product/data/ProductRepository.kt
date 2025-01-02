package com.example.fashionshop.features.product.data

interface ProductRepository {
    suspend fun getAllProducts()

    suspend fun getProductDetails()
}