package com.example.fashionshop.features.favorite.data

import com.example.fashionshop.common.NetworkResponse

interface FavoriteProductRepository{
    suspend fun getAllFavoriteProductsById(id: String): NetworkResponse<List<Product_User>>
    suspend fun addFavoriteProduct(productUser: Product_User): NetworkResponse<String>
    suspend fun deleteFavoriteProduct(productUser: Product_User): NetworkResponse<String>
}