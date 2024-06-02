package com.example.lab8retrofit

import com.example.lab8retrofit.Model.search
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ConsumirApi {
    @GET("1.0/search/{query}")
    fun searchBooks(@Path("query") query: String): Call<search>
}
