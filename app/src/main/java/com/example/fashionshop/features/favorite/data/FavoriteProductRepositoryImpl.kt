package com.example.fashionshop.features.favorite.data

import android.util.Log
import com.example.fashionshop.common.NetworkResponse
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

const val favoriteProductsCollection = "favorite_products"

class FavoriteProductRepositoryImpl(
    private val db: FirebaseFirestore,
) : FavoriteProductRepository {
    override suspend fun getAllFavoriteProductsById(id: String): NetworkResponse<List<Product_User>> {
        return try {
            val t =
                db.collection(favoriteProductsCollection)
                    .whereEqualTo("userId", id)
                    .get()
                    .await()

            val a = t.map { doc ->
                Product_User(
                    doc.id, doc.data["productId"].toString(),
                    doc.data["userId"].toString()
                )
            }
            NetworkResponse.Success(a)
        } catch (e: Exception) {
            NetworkResponse.Error(e.toString())
        }

    }

    override suspend fun addFavoriteProduct(productUser: Product_User): NetworkResponse<String> {
        return try {
            db.collection(favoriteProductsCollection).add(productUser).await()
            NetworkResponse.Success("Successfully added")
        } catch (e: Exception) {
            NetworkResponse.Error(e.toString())
        }
    }

    override suspend fun deleteFavoriteProduct(productUser: Product_User): NetworkResponse<String> {
        return try {
            db.collection(favoriteProductsCollection).document(productUser.id).delete().await()
            NetworkResponse.Success("Successfully deleted")
        } catch (e: Exception) {
            NetworkResponse.Error(e.toString())
        }
    }
}