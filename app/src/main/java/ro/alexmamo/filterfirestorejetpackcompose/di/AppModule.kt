package ro.alexmamo.filterfirestorejetpackcompose.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.NAME
import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.PRODUCTS
import ro.alexmamo.filterfirestorejetpackcompose.data.repository.ProductListRepositoryImpl
import ro.alexmamo.filterfirestorejetpackcompose.domain.repository.ProductListRepository

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideFirebaseFirestore() = Firebase.firestore

    @Provides
    fun provideProductsQuery(
        db: FirebaseFirestore
    ) = db.collection(PRODUCTS).orderBy(NAME)

    @Provides
    fun provideProductListRepository(
        productsQuery: Query
    ): ProductListRepository = ProductListRepositoryImpl(productsQuery)
}