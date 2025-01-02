package com.example.fashionshop.features.account.profile.domain

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fashionshop.common.NetworkResponse
import com.example.fashionshop.features.account.common.data.repository.ProfileRepository
import com.example.fashionshop.features.account.common.domain.model.User
import com.example.fashionshop.features.account.common.domain.utils.UserDataMapper
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    private var auth: FirebaseAuth,
    private val userDataMapper: UserDataMapper,
) : ViewModel() {
    private var _user = MutableStateFlow(User())
    val user: StateFlow<User> = _user

    fun getUserInfo() {
        viewModelScope.launch {
            when (val response = profileRepository.getUserInfo(auth.currentUser?.uid.toString())) {
                is NetworkResponse.Success -> {
                    response.data.let {
                        _user.value = userDataMapper.transform(it)
                    }
                }

                is NetworkResponse.Error -> {
                    Log.e("error", response.message)
                }
            }
        }
    }
}