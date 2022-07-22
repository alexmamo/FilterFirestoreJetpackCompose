package ro.alexmamo.filterfirestorejetpackcompose.presentation.product_details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_details.components.ProductDetailsContent
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_details.components.ProductDetailsTopBar

@Composable
fun ProductDetailsScreen(
    navigateBack: () -> Unit,
    productName: String
) {
    Scaffold(
        topBar = {
            ProductDetailsTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            ProductDetailsContent(
                padding = padding,
                productName = productName
            )
        }
    )
}