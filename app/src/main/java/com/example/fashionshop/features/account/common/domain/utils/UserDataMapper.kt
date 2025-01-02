package com.example.fashionshop.features.account.common.domain.utils

import com.example.fashionshop.features.account.common.data.model.UserDTO
import com.example.fashionshop.features.account.common.domain.model.User

class UserDataMapper {

    fun transform(userDTO: UserDTO): User {
        return User(
            email = userDTO.email,
            name = userDTO.name,
            surname = userDTO.surname,
            deliveryPoint = userDTO.deliveryPoint,
            birthday = userDTO.birthday,
            imageUri = userDTO.imageUri,
            isAcceptedEmailNews = userDTO.isAcceptedEmailNews,
        )
    }

    fun transform(userDTOList: List<UserDTO>): List<User> {
        val userList: MutableList<User> = mutableListOf()
        for (u in userDTOList) {
            userList.add(transform(u))
        }
        return userList
    }
}