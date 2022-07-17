package ro.alexmamo.filterfirestorejetpackcompose.domain.repository

import kotlinx.coroutines.flow.Flow
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Product
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Response

typealias ProductList = List<Product>
typealias ProductListResponse = Response<ProductList>

interface ProductListRepository {
    fun getProductListFromFirestore(searchText: String): Flow<ProductListResponse>
}