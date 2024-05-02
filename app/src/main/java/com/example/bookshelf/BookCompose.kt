import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import RetrofitInstance

class BookViewModel : ViewModel() {
    private val repository = BookRepository()

    private val _books = mutableStateOf<List<Book>>(emptyList())
    val books: List<Book> by _books

    fun searchBooks(query: String) {
        viewModelScope.launch {
            _books.value = repository.searchBooks(query)
        }
    }
}

data class Book(val title: String, val imageUrl: String)

class BookRepository {
    private val service = RetrofitInstance.googleBooksService

    suspend fun searchBooks(query: String): List<Book> {
        val response = service.searchBooks(query)
        return response.items.map { item ->
            Book(
                title = item.volumeInfo.title ?: "",
                imageUrl = item.volumeInfo.imageLinks?.thumbnail ?: ""
            )
        }
    }
}

@Composable
fun BookList(bookViewModel: BookViewModel) {
    val books = bookViewModel.books // Obtenemos directamente la lista de libros

    LazyColumn {
        items(books) { book ->
            BookItem(book = book)
        }
    }
}


@Composable
fun BookItem(book: Book) {
    // Aquí muestra la información de cada libro (título, imagen, etc.)
}
