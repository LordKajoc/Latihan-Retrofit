package com.lordkajoc.latihan_retrofit.model
import com.google.gson.annotations.SerializedName

data class GetAllNewsResponesItem(
    @SerializedName("author")
    val author: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("title")
    val title: String
)