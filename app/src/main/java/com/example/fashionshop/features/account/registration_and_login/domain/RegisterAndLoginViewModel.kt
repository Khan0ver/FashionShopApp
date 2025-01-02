package com.example.fashionshop.features.account.registration_and_login.domain

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fashionshop.common.NetworkResponse
import com.example.fashionshop.features.account.common.data.model.AuthState
import com.example.fashionshop.features.account.common.data.repository.UserAuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterAndLoginViewModel @Inject constructor(
    private val userAuthRepository: UserAuthRepository,
    private val auth: FirebaseAuth,
) : ViewModel() {

    private var _currentUser = MutableStateFlow(auth.currentUser)
    val currentUser: StateFlow<FirebaseUser?> = _currentUser

    private var _authState = MutableStateFlow(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState

    fun signIn(email: String, password: String) {
        _authState.value = AuthState.Loading

        viewModelScope.launch {
            when (val result = userAuthRepository.signIn(email, password)) {
                is NetworkResponse.Success -> {
                    _authState.value = AuthState.Success
                    _currentUser.value = auth.currentUser
                }

                is NetworkResponse.Error -> {
                    _authState.value = AuthState.Failed
                    Log.e("Network response error", result.toString())
                }
            }
        }
    }

    fun signUpWithEmailAndPassword(email: String, password: String, name: String, surname: String) {
        _authState.value = AuthState.Loading

        viewModelScope.launch {
            when (val result = userAuthRepository.signUp(email, password, name, surname)) {
                is NetworkResponse.Error -> {
                    _authState.value = AuthState.Success
                    Log.e("Error", result.toString())
                }

                is NetworkResponse.Success -> {
                    _authState.value = AuthState.Failed
                    _currentUser.value = auth.currentUser
                }
            }
        }
    }
}