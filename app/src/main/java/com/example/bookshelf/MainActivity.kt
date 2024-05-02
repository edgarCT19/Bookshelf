package com.example.bookshelf

import BookViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.bookshelf.ui.theme.BookshelfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // Corregimos la referencia a Bundle
        super.onCreate(savedInstanceState)
        setContent {
            BookshelfTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Utilizamos remember para recordar el ViewModel
                    val bookViewModel = remember {
                        // Utilizamos ViewModelProvider para obtener el ViewModel
                        ViewModelProvider(this).get(BookViewModel::class.java)
                    }
                    // Utilizamos BookList para mostrar la lista de libros
                    BookList(bookViewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BookshelfTheme {
        Greeting("Android")
    }
}

@Composable
fun Greeting(s: String) {
    // Implementa la funcionalidad de Greeting aquí
    // Por ejemplo, muestra un texto que salude a "s"
}

@Composable
fun BookList(bookViewModel: BookViewModel) {
    // Implementa la funcionalidad de BookList aquí
    // Por ejemplo, muestra una lista de libros usando el ViewModel proporcionado
}
