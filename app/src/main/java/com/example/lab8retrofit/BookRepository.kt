package com.example.lab8retrofit.repository

import com.example.lab8retrofit.Model.search
import com.example.lab8retrofit.Network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookRepository {
    fun searchBooks(query: String, callback: (search?) -> Unit) {
        val call = ApiClient.consumirApi.searchBooks(query)
        call.enqueue(object : Callback<search> {
            override fun onResponse(call: Call<search>, response: Response<search>) {
                if (response.isSuccessful) {
                    callback(response.body())
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<search>, t: Throwable) {
                callback(null)
            }
        })
    }
}
