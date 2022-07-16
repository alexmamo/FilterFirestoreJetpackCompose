package ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Product

@Composable
fun ProductCard(
    product: Product,
    onProductClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 12.dp)
                .clickable {
                    onProductClick()
                },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            product.name?.let { productName ->
                Text(
                    text = productName,
                    color = Color.DarkGray,
                    fontSize = 25.sp
                )
            }
        }
    }
}