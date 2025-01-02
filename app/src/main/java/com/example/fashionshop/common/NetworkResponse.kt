package com.example.fashionshop.common

sealed class NetworkResponse<T> {
    data class Success<T>(val data: T) : NetworkResponse<T>()
    data class Error<T>(val message: String) : NetworkResponse<T>()
}