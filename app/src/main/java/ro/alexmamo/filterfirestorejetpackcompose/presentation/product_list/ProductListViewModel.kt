package ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.EMPTY_STRING
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Response.Success
import ro.alexmamo.filterfirestorejetpackcompose.domain.repository.ProductListRepository
import ro.alexmamo.filterfirestorejetpackcompose.domain.repository.ProductListResponse
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repo: ProductListRepository
): ViewModel() {
    private val _productListState = mutableStateOf<ProductListResponse>(Success(emptyList()))
    val productListState: State<ProductListResponse> = _productListState

    init {
        getProductList(EMPTY_STRING)
    }

    fun getProductList(searchText: String) = viewModelScope.launch {
        repo.getProductListFromFirestore(searchText).collect { response ->
            _productListState.value = response
        }
    }
}