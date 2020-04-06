package com.daniel.farre.yogasolotest.data

import com.daniel.farre.yogasolotest.domain.Posture

interface IPosturesRepository {
    suspend fun getPostures(): List<Posture>
    suspend fun getPostureDetail(id: String): Posture
}