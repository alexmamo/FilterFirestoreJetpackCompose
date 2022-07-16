package ro.alexmamo.filterfirestorejetpackcompose.data.repository

import com.google.firebase.firestore.Query
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Product
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Response.Error
import ro.alexmamo.filterfirestorejetpackcompose.domain.model.Response.Success
import ro.alexmamo.filterfirestorejetpackcompose.domain.repository.ProductListRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductListRepositoryImpl @Inject constructor(
    private var productsQuery: Query
): ProductListRepository {
    override fun getProductListFromFirestore(searchText: String) = callbackFlow {
        if (searchText.isNotEmpty()) {
            productsQuery = productsQuery.startAt(searchText).endAt("$searchText\uf8ff")
        }
        val snapshotListener = productsQuery.addSnapshotListener { snapshot, e ->
            val response = if (snapshot != null) {
                val productList = snapshot.toObjects(Product::class.java)
                Success(productList)
            } else {
                Error(e?.message ?: e.toString())
            }
            trySend(response).isSuccess
        }
        awaitClose {
            snapshotListener.remove()
        }
    }
}