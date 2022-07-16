package ro.alexmamo.filterfirestorejetpackcompose.navigation

import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.PRODUCT_LIST_SCREEN
import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.PRODUCT_DETAILS_SCREEN
import ro.alexmamo.filterfirestorejetpackcompose.core.Constants.PRODUCT_SEARCH_SCREEN

sealed class Screen(val route: String) {
    object ProductListScreen: Screen(PRODUCT_LIST_SCREEN)
    object ProductSearchScreen: Screen(PRODUCT_SEARCH_SCREEN)
    object ProductDetailsScreen: Screen(PRODUCT_DETAILS_SCREEN)
}