package com.example.fashionshop.features.account.profile.data

import com.example.fashionshop.common.NetworkResponse
import com.example.fashionshop.features.account.common.data.model.UserDTO
import com.example.fashionshop.features.account.common.data.repository.ProfileRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await

class ProfileRepositoryImpl(
    private val db: FirebaseFirestore,
) : ProfileRepository {
    override suspend fun getUserInfo(uid: String): NetworkResponse<UserDTO> {
        return try {
            val user = db.collection("users").document(uid).get()
                .await().toObject<UserDTO>()!!
            NetworkResponse.Success(user)
        } catch (e: Exception) {
            NetworkResponse.Error(e.toString())
        }
    }
}