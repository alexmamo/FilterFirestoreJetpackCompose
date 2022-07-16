package ro.alexmamo.filterfirestorejetpackcompose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.NO_PRODUCTS_FOUND

@Composable
fun NoSearchResults() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = NO_PRODUCTS_FOUND
        )
    }
}