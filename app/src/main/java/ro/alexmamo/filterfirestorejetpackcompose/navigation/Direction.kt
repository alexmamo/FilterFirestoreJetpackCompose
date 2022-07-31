package ro.alexmamo.filterfirestorejetpackcompose.navigation

import androidx.navigation.NavHostController
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Product
import ro.alexmamo.filterfirestorejetpackcompose.navigation.Screen.ProductDetailsScreen
import ro.alexmamo.filterfirestorejetpackcompose.navigation.Screen.ProductSearchScreen

class Direction(
    navController: NavHostController
) {
    val navigateToProductSearchScreen: () -> Unit = {
        navController.navigate(ProductSearchScreen.route)
    }

    val navigateToProductDetailsScreen: (Product) -> Unit = { product ->
        navController.navigate("${ProductDetailsScreen.route}/${product.name}")
    }

    val navigateBack: () -> Unit = {
        navController.navigateUp()
    }
}