package com.example.fashionshop.features.account.common.data.repository

import com.example.fashionshop.common.NetworkResponse

interface UserAuthRepository {
    suspend fun signUp(
        email: String,
        password: String,
        name: String,
        surname: String
    ): NetworkResponse<String>

    suspend fun signIn(email: String, password: String): NetworkResponse<String>

    suspend fun signOut(): NetworkResponse<String>
}