package ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Response.Loading
import ro.alexmamo.filterfirestorejetpackcompose.domain.repository.ProductListRepository
import ro.alexmamo.filterfirestorejetpackcompose.domain.repository.ProductListResponse
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repo: ProductListRepository
): ViewModel() {
    var productListResponse by mutableStateOf<ProductListResponse>(Loading)
        private set

    fun getProductList(searchText: String) = viewModelScope.launch {
        repo.getProductListFromFirestore(searchText).collect { response ->
            productListResponse = response
        }
    }
}