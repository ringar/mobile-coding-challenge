package com.daniel.farre.yogasolotest.data.remote

import com.daniel.farre.yogasolotest.data.IPosturesRepository
import com.daniel.farre.yogasolotest.domain.Posture
import com.daniel.farre.yogasolotest.domain.PostureMapper

class RemotePosturesRepository (
    private val postureMapper: PostureMapper,
    private val api: PosturesApi
) : IPosturesRepository {
    override suspend fun getPostures(): List<Posture> =
        runCatching {
            api.postures().map {
                postureMapper.toPosture(it)
            }
        }.getOrElse {
            throw it
        }

    override suspend fun getPostureDetail(id: String): Posture =
        runCatching {
            postureMapper.toPosture(api.posture(id))
        }.getOrElse {
            throw it
        }
}