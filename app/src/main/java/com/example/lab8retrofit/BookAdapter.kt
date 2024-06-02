package com.example.lab8retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab8retrofit.Model.Book
import com.example.lab8retrofit.databinding.ItemUsersBinding
import com.squareup.picasso.Picasso

class BookAdapter(private var bookList: List<Book>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookList[position])
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    fun updateBooks(books: List<Book>) {
        bookList = books
        notifyDataSetChanged()
    }

    class BookViewHolder(private val binding: ItemUsersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.nameTextView.text = book.title
            Picasso.get().load(book.image).into(binding.imageView)
        }
    }
}
