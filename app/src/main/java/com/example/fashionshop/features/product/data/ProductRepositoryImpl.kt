package com.example.fashionshop.features.product.data

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class ProductRepositoryImpl (
    private val db: FirebaseFirestore
): ProductRepository {
    override suspend fun getAllProducts() {
        TODO("Not yet implemented")
    }

    override suspend fun getProductDetails() {
        TODO("Not yet implemented")
    }
}