package com.daniel.farre.yogasolotest.domain

import com.daniel.farre.yogasolotest.data.PosturesRepository

class PosturesService (
    private val repository: PosturesRepository
) {
    suspend fun getPostures(): List<Posture> = repository.getPostures()
    suspend fun getPostureDetail(id: String): Posture = repository.getPostureDetail(id)
}