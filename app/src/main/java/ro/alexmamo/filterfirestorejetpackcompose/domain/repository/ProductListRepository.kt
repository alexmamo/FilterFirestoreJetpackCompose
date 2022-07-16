package ro.alexmamo.filterfirestorejetpackcompose.domain.repository

import kotlinx.coroutines.flow.Flow
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list.ProductListResponse

interface ProductListRepository {
    fun getProductListFromFirestore(searchText: String): Flow<ProductListResponse>
}