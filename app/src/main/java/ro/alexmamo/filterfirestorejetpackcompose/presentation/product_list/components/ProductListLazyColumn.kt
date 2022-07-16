package ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Product

@Composable
fun ProductListLazyColumn(
    padding: PaddingValues,
    productList: List<Product>,
    navigateToProductDetailsScreen: (productName: String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(
            items = productList
        ) { product ->
            ProductCard(
                product = product,
                onProductClick = {
                    product.name?.let { productName ->
                        navigateToProductDetailsScreen(productName)
                    }
                }
            )
        }
    }
}