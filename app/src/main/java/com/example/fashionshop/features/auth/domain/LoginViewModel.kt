package com.example.fashionshop.features.auth.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fashionshop.features.auth.data.model.AuthState
import com.example.fashionshop.features.auth.data.repository.UserAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userAuthRepository: UserAuthRepository
) : ViewModel() {
    private var _authState = MutableLiveData(AuthState.Idle)
    val authState: LiveData<AuthState> = _authState

    fun signIn(email: String, password: String) {
        _authState.value = AuthState.Loading
        userAuthRepository.signIn(email, password, _authState)
    }

    fun signOut() {
        userAuthRepository.signOut()
    }
}