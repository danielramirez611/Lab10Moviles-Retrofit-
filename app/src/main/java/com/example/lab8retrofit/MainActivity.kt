package com.example.lab8retrofit

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab8retrofit.Model.Book
import com.example.lab8retrofit.databinding.ActivityMainBinding
import com.example.lab8retrofit.viewmodel.BookViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: BookAdapter
    private val bookViewModel: BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar RecyclerView y su adaptador
        adapter = BookAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Agregar TextWatcher al EditText
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No hacer nada
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString()
                if (query.isNotEmpty()) {
                    bookViewModel.searchBooks(query)
                } else {
                    adapter.updateBooks(emptyList())
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // No hacer nada
            }
        })

        bookViewModel.books.observe(this, Observer { books ->
            adapter.updateBooks(books)
        })
    }
}
