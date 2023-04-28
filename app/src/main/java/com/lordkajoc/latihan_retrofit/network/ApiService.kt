package com.lordkajoc.latihan_retrofit.network

import com.lordkajoc.latihan_retrofit.model.GetAllFIlmResponseItem
import com.lordkajoc.latihan_retrofit.model.GetAllNewsResponesItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    //GET digunakan untuk memanggil semua data yang terdapat pada server
    @GET("news")
    fun getAllNews(): Call<List<GetAllNewsResponesItem>>

    @GET("film")
    fun getAllFilm(): Call<List<GetAllFIlmResponseItem>>
}