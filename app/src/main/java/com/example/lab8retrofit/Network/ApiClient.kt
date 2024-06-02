package com.example.lab8retrofit.Network

import com.example.lab8retrofit.ConsumirApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://api.itbook.store/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val consumirApi: ConsumirApi = retrofit.create(ConsumirApi::class.java)
}
