package com.lordkajoc.latihan_retrofit.model


import com.google.gson.annotations.SerializedName

data class GetAllFIlmResponseItem(
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("description ")
    val description2: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
)