package ro.alexmamo.filterfirestorejetpackcompose.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Product

@Composable
@ExperimentalMaterialApi
fun ProductListContent(
    padding: PaddingValues,
    productList: List<Product>,
    navigateToProductDetailsScreen: (product: Product) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        items(
            items = productList
        ) { product ->
            ProductCard(
                product = product,
                onClick = {
                    navigateToProductDetailsScreen(product)
                }
            )
        }
    }
}