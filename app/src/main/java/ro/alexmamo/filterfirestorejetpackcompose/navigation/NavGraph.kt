package ro.alexmamo.filterfirestorejetpackcompose.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Product
import ro.alexmamo.filterfirestorejetpackcompose.navigation.Screen.*
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_details.ProductDetailsScreen
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list.ProductListScreen
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_search.ProductSearchScreen

@Composable
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ProductListScreen.route
    ) {
        fun navigateToProductSearchScreen() = navController.navigate(ProductSearchScreen.route)

        fun navigateToProductDetailsScreen(
            product: Product
        ) = navController.navigate("${ProductDetailsScreen.route}/${product.name}")

        fun navigateBack() = navController.popBackStack()

        composable(
            route = ProductListScreen.route
        ) {
            ProductListScreen(
                navigateToProductSearchScreen = {
                    navigateToProductSearchScreen()
                },
                navigateToProductDetailsScreen = { productName ->
                    navigateToProductDetailsScreen(productName)
                }
            )
        }
        composable(
            route = ProductSearchScreen.route
        ) {
            ProductSearchScreen(
                navigateBack = {
                    navigateBack()
                },
                navigateToProductDetailsScreen = { productName ->
                    navigateToProductDetailsScreen(productName)
                }
            )
        }
        composable(
            route = "${ProductDetailsScreen.route}/{productName}",
            arguments = listOf(
                navArgument("productName") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val productName = backStackEntry.arguments?.getString("productName") ?: ""
            ProductDetailsScreen(
                navigateBack = {
                    navigateBack()
                },
                productName = productName
            )
        }
    }
}