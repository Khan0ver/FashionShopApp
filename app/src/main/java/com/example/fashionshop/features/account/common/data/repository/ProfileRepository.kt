package com.example.fashionshop.features.account.common.data.repository

import com.example.fashionshop.common.NetworkResponse
import com.example.fashionshop.features.account.common.data.model.UserDTO

interface ProfileRepository {
    suspend fun getUserInfo(uid: String): NetworkResponse<UserDTO>
}