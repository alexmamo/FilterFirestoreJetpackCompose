package ro.alexmamo.filterfirestorejetpackcompose.presentation.product_search.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.filterfirestorejetpackcompose.components.NoSearchResults
import ro.alexmamo.filterfirestorejetpackcompose.components.ProgressBar
import ro.alexmamo.filterfirestorejetpackcompose.core.Utils.Companion.print
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Response.*
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list.ProductListViewModel
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list.components.ProductListLazyColumn

@Composable
fun ProductSearchContent(
    viewModel: ProductListViewModel = hiltViewModel(),
    padding: PaddingValues,
    savedValue: TextFieldValue,
    navigateToProductDetailsScreen: (productName: String) -> Unit
) {
    val searchText = savedValue.text
    viewModel.getProductList(searchText)
    when(val productsResponse = viewModel.productListState.value) {
        is Loading -> ProgressBar()
        is Success -> {
            val productList = productsResponse.data
            if (productList.isNotEmpty()) {
                ProductListLazyColumn(
                    padding = padding,
                    productList = productList,
                    navigateToProductDetailsScreen = navigateToProductDetailsScreen
                )
            } else {
                if (searchText.isNotEmpty()) {
                    NoSearchResults()
                }
            }
        }
        is Error -> print(productsResponse.message)
    }
}