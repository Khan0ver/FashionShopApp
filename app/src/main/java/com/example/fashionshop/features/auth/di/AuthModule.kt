package com.example.fashionshop.features.auth.di

import com.example.fashionshop.features.auth.data.UserAuthRepositoryImpl
import com.example.fashionshop.features.auth.data.repository.UserAuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AuthModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = Firebase.auth

    @Provides
    fun provideUserAuthRepository(
        auth: FirebaseAuth
    ): UserAuthRepository = UserAuthRepositoryImpl(auth)
}