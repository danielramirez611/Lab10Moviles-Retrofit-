package com.example.lab8retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab8retrofit.Model.Book
import com.example.lab8retrofit.repository.BookRepository

class BookViewModel : ViewModel() {
    private val repository = BookRepository()
    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    fun searchBooks(query: String) {
        repository.searchBooks(query) { searchResult ->
            _books.postValue(searchResult?.books ?: emptyList())
        }
    }
}
