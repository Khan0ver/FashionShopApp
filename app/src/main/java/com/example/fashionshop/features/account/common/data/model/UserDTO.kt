package com.example.fashionshop.features.account.common.data.model

data class UserDTO(
    val uid: String = "",
    val email: String = "",
    val name: String = "",
    val surname: String = "",
    val deliveryPoint: Int = -1,
    val birthday: String = "",
    val imageUri: String = "",
    val isAcceptedEmailNews: Boolean = false,
    val country: String = "",
    val city: String = "",
)
