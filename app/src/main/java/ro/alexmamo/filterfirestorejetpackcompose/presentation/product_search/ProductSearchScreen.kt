package ro.alexmamo.filterfirestorejetpackcompose.presentation.product_search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.text.input.TextFieldValue
import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.EMPTY_STRING
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_search.components.ProductSearchContent
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_search.components.ProductSearchTopBar

@Composable
@ExperimentalComposeUiApi
fun ProductSearchScreen(
    navigateBack: () -> Unit,
    navigateToProductDetailsScreen: (productName: String) -> Unit
) {
    var savedValue by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(EMPTY_STRING))
    }

    fun onSearchTextChanged(newSearchText: TextFieldValue) {
        savedValue = newSearchText
    }

    fun onCloseIconClick() {
        savedValue = TextFieldValue(EMPTY_STRING)
    }

    Scaffold(
        topBar = {
            ProductSearchTopBar(
                savedValue = savedValue,
                onSearchTextChanged = { newSearchText ->
                    onSearchTextChanged(newSearchText)
                },
                onCloseIconClick = {
                    onCloseIconClick()
                },
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            ProductSearchContent(
                padding = padding,
                savedValue = savedValue,
                navigateToProductDetailsScreen = navigateToProductDetailsScreen
            )
        }
    )
}