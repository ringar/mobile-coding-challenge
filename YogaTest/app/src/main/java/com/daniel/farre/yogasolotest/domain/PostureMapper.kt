package com.daniel.farre.yogasolotest.domain

import com.daniel.farre.yogasolotest.data.remote.PosturesResponse

class PostureMapper{

    fun <T> toPosture(posture: T): Posture {
        return when(posture) {
            is PosturesResponse -> Posture(posture.id, posture.name, posture.teacher, posture.duration, posture.picture, posture.description)
            else -> Posture()
        }
    }
}