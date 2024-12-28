package com.example.fashionshop.features.auth.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.fashionshop.features.auth.data.repository.UserAuthRepository
import com.example.fashionshop.features.auth.data.model.AuthState
import com.google.firebase.auth.FirebaseAuth

class UserAuthRepositoryImpl(
    private var auth: FirebaseAuth
) : UserAuthRepository {
    override fun signUp(
        email: String,
        password: String,
        authState: MutableLiveData<AuthState>
    ) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                authState.value = AuthState.Success
            } else {
                authState.value = AuthState.Failed
                Log.e("Error from FirebaseAuth", task.exception.toString())
            }
        }
    }

    override fun signIn(email: String, password: String, authState: MutableLiveData<AuthState>) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                if (task.isSuccessful) {
                    authState.value = AuthState.Success
                } else {
                    authState.value = AuthState.Failed
                    Log.e("Error from FirebaseAuth", task.exception.toString())
                }
            }
        }
    }

    override fun signOut() {
        auth.signOut()
    }
}