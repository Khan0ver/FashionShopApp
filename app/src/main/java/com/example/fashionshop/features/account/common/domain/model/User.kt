package com.example.fashionshop.features.account.common.domain.model

data class User(
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
