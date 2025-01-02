package com.example.fashionshop.di

import com.example.fashionshop.features.favorite.data.FavoriteProductRepository
import com.example.fashionshop.features.favorite.data.FavoriteProductRepositoryImpl
import com.example.fashionshop.features.product.data.ProductRepository
import com.example.fashionshop.features.product.data.ProductRepositoryImpl
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ProductModule {
    @Provides
    fun provideProductRepository(
        database: FirebaseFirestore
    ): ProductRepository = ProductRepositoryImpl(database)

    @Provides
    fun provideFavoriteProductRepository(
        database: FirebaseFirestore
    ): FavoriteProductRepository = FavoriteProductRepositoryImpl(database)
}