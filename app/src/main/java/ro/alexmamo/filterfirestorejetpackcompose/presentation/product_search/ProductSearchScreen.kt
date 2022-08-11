package ro.alexmamo.filterfirestorejetpackcompose.presentation.product_search

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.filterfirestorejetpackcompose.components.Message
import ro.alexmamo.filterfirestorejetpackcompose.components.ProductListContent
import ro.alexmamo.filterfirestorejetpackcompose.components.ProgressBar
import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.NO_PRODUCTS_FOUND
import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.NO_SEARCH
import ro.alexmamo.filterfirestorejetpackcompose.core.Utils.Companion.printMessage
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Product
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Response.*
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list.ProductListViewModel
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_search.components.ProductSearchTopBar

@Composable
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
fun ProductSearchScreen(
    viewModel: ProductListViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
    navigateToProductDetailsScreen: (product: Product) -> Unit
) {
    var search by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(NO_SEARCH))
    }

    Scaffold(
        topBar = {
            ProductSearchTopBar(
                search = search,
                onSearchTextChanged = { newSearchText ->
                    search = newSearchText
                },
                onCloseIconClick = {
                    search = TextFieldValue(NO_SEARCH)
                },
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            val searchText = search.text
            LaunchedEffect(Unit) {
                viewModel.getProductList(searchText)
            }
            when(val productListResponse = viewModel.productListResponse) {
                is Loading -> ProgressBar()
                is Success -> {
                    val productList = productListResponse.data
                    if (productList.isNotEmpty()) {
                        ProductListContent(
                            padding = padding,
                            productList = productList,
                            navigateToProductDetailsScreen = navigateToProductDetailsScreen
                        )
                    } else {
                        if (searchText.isNotEmpty()) {
                            Message(
                                text = NO_PRODUCTS_FOUND
                            )
                        }
                    }
                }
                is Error -> printMessage(productListResponse.message)
            }
        }
    )
}