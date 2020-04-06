package com.daniel.farre.yogasolotest.data

import com.daniel.farre.yogasolotest.data.remote.RemotePosturesRepository
import com.daniel.farre.yogasolotest.domain.Posture

class PosturesRepository (
    private val remoteRepository: RemotePosturesRepository
) : IPosturesRepository {

    override suspend fun getPostures(): List<Posture> =
        runCatching {
            remoteRepository.getPostures()
        }.getOrElse {
            throw it
        }

    override suspend fun getPostureDetail(id: String): Posture =
        runCatching {
            remoteRepository.getPostureDetail(id)
        }.getOrElse {
            throw it
        }
}