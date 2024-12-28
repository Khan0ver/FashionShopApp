package com.example.fashionshop.features.auth.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.fashionshop.features.auth.data.model.AuthState

interface UserAuthRepository {
    fun signUp(email: String, password: String, authState: MutableLiveData<AuthState>)

    fun signIn(email: String, password: String, authState: MutableLiveData<AuthState>)

    fun signOut()
}