package ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.filterfirestorejetpackcompose.components.ProgressBar
import ro.alexmamo.filterfirestorejetpackcompose.core.Utils.Companion.print
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Response.*
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list.ProductListViewModel

@Composable
fun ProductListContent(
    viewModel: ProductListViewModel = hiltViewModel(),
    padding: PaddingValues,
    navigateToProductDetailsScreen: (productName: String) -> Unit
) {
    when(val productsResponse = viewModel.productListState.value) {
        is Loading -> ProgressBar()
        is Success -> ProductListLazyColumn(
            padding = padding,
            productList = productsResponse.data,
            navigateToProductDetailsScreen = navigateToProductDetailsScreen
        )
        is Error -> print(productsResponse.message)
    }
}