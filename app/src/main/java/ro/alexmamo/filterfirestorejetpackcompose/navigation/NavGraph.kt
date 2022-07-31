package ro.alexmamo.filterfirestorejetpackcompose.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.NO_PRODUCT_NAME
import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.PRODUCT_NAME
import ro.alexmamo.filterfirestorejetpackcompose.navigation.Screen.*
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_details.ProductDetailsScreen
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_list.ProductListScreen
import ro.alexmamo.filterfirestorejetpackcompose.presentation.product_search.ProductSearchScreen

@Composable
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
fun NavGraph() {
    val navController = rememberNavController()
    val direction = remember(navController) { Direction(navController) }

    NavHost(
        navController = navController,
        startDestination = ProductListScreen.route
    ) {
        composable(
            route = ProductListScreen.route
        ) {
            ProductListScreen(
                navigateToProductSearchScreen = {
                    direction.navigateToProductSearchScreen()
                },
                navigateToProductDetailsScreen = { productName ->
                    direction.navigateToProductDetailsScreen(productName)
                }
            )
        }
        composable(
            route = ProductSearchScreen.route
        ) {
            ProductSearchScreen(
                navigateBack = {
                    direction.navigateBack()
                },
                navigateToProductDetailsScreen = { productName ->
                    direction.navigateToProductDetailsScreen(productName)
                }
            )
        }
        composable(
            route = "${ProductDetailsScreen.route}/{$PRODUCT_NAME}",
            arguments = listOf(
                navArgument(PRODUCT_NAME) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val productName = backStackEntry.arguments?.getString(PRODUCT_NAME) ?: NO_PRODUCT_NAME
            ProductDetailsScreen(
                navigateBack = {
                    direction.navigateBack()
                },
                productName = productName
            )
        }
    }
}