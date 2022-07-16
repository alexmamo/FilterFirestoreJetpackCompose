package ro.alexmamo.filterfirestorejetpackcompose.presentation.product_details.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.PRODUCT_DETAILS_SCREEN

@Composable
fun ProductDetailsTopBar(
    onArrowBackClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = PRODUCT_DETAILS_SCREEN
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onArrowBackClick
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        }
    )
}