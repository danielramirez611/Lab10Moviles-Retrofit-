package com.example.lab8retrofit.Model

data class search(
    val books: List<Book>,
    val error: String,
    val page: String,
    val total: String
)