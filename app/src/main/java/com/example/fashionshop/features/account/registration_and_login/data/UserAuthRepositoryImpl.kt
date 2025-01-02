package com.example.fashionshop.features.account.registration_and_login.data

import com.example.fashionshop.common.NetworkResponse
import com.example.fashionshop.features.account.common.data.model.UserDTO
import com.example.fashionshop.features.account.common.data.repository.UserAuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UserAuthRepositoryImpl(
    private var auth: FirebaseAuth,
    private var dbRef: FirebaseFirestore,
) : UserAuthRepository {

    override suspend fun signUp(
        email: String,
        password: String,
        name: String,
        surname: String
    ): NetworkResponse<String> {
        return try {
            auth.createUserWithEmailAndPassword(email, password).await()
            dbRef.collection("users").document(auth.currentUser?.uid.toString())
                .set(
                    UserDTO(
                        uid = auth.currentUser?.uid.toString(),
                        email = email,
                        name = name,
                        surname = surname,
                    )
                ).await()

            NetworkResponse.Success("")
        } catch (e: Exception) {
            NetworkResponse.Error(e.toString())
        }
    }

    override suspend fun signIn(email: String, password: String): NetworkResponse<String> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            NetworkResponse.Success(result.user?.uid ?: "")
        } catch (e: Exception) {
            NetworkResponse.Error(e.toString())
        }
    }

    override suspend fun signOut(): NetworkResponse<String> {
        return try {
            auth.signOut()
            NetworkResponse.Success("")
        } catch (e: Exception) {
            NetworkResponse.Error(e.toString())
        }
    }
}