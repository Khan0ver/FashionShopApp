package com.example.fashionshop.features.account.edit_profile.data

import com.example.fashionshop.common.NetworkResponse
import com.example.fashionshop.features.account.common.data.model.UserDTO
import com.example.fashionshop.features.account.common.data.repository.ProfileRepository

class ProfileRepositoryImpl: ProfileRepository {
    override suspend fun getUserInfo(uid: String): NetworkResponse<UserDTO> {
        TODO("Not yet implemented")
    }
}