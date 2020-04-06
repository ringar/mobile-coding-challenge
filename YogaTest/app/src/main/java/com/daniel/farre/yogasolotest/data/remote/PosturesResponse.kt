package com.daniel.farre.yogasolotest.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PosturesResponse (
    @SerializedName("id")
    @Expose
    val id: String = "",
    @SerializedName("name")
    @Expose
    val name: String = "",
    @SerializedName("teacher")
    @Expose
    val teacher: String = "",
    @SerializedName("duration")
    @Expose
    val duration: String = "",
    @SerializedName("picture")
    @Expose
    val picture: String = "",
    @SerializedName("description")
    @Expose
    val description: String = ""
)