package ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.filterfirestorejetpackcompose.components.ProductListContent
import ro.alexmamo.filterfirestorejetpackcompose.components.ProgressBar
import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.NO_SEARCH
import ro.alexmamo.filterfirestorejetpackcompose.core.Utils.Companion.printMessage
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Product
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Response.*
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list.components.ProductListTopBar

@Composable
@ExperimentalMaterialApi
fun ProductListScreen(
    viewModel: ProductListViewModel = hiltViewModel(),
    navigateToProductSearchScreen: () -> Unit,
    navigateToProductDetailsScreen: (product: Product) -> Unit
) {
    Scaffold(
        topBar = {
            ProductListTopBar(
                onSearchIconClick = navigateToProductSearchScreen
            )
        },
        content = { padding ->
            viewModel.getProductList(NO_SEARCH)
            when(val productListResponse = viewModel.productListResponse) {
                is Loading -> ProgressBar()
                is Success -> ProductListContent(
                    padding = padding,
                    productList = productListResponse.data,
                    navigateToProductDetailsScreen = navigateToProductDetailsScreen
                )
                is Error -> printMessage(productListResponse.message)
            }
        }
    )
}