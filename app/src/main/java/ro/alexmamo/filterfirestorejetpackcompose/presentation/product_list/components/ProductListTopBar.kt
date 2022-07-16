package ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.PRODUCT_LIST_SCREEN

@Composable
fun ProductListTopBar(
    onSearchIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = PRODUCT_LIST_SCREEN
            )
        },
        actions = {
            IconButton(
                onClick = onSearchIconClick
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = null
                )
            }
        }
    )
}