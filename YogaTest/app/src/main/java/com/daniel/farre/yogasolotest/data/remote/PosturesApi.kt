package com.daniel.farre.yogasolotest.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface PosturesApi {

    @GET("/postures")
    suspend fun postures(): List<PosturesResponse>

    @GET("/postures_detail/{id}")
    suspend fun posture(
        @Path("id") id: String
    ): PosturesResponse
}