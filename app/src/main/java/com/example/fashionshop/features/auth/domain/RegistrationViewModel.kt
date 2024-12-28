package com.example.fashionshop.features.auth.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fashionshop.features.auth.data.model.AuthState
import com.example.fashionshop.features.auth.data.repository.UserAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val userAuthRepository: UserAuthRepository
) : ViewModel() {
    private var _authState = MutableLiveData(AuthState.Idle)
    val authState: LiveData<AuthState> = _authState

    /*
    private var _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private var _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private var _surname = MutableLiveData<String>()
    val surname: LiveData<String> = _surname

    private var _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private var _password = MutableLiveData<String>()
    val password: LiveData<String> = _password
     */

    fun signUpWithEmailAndPassword(email: String, password: String) {
        _authState.value = AuthState.Loading
        userAuthRepository.signUp(email, password, _authState)
    }
}