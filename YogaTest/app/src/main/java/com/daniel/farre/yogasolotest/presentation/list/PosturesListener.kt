package com.daniel.farre.yogasolotest.presentation.list

import com.daniel.farre.yogasolotest.domain.Posture

interface PosturesListener {
    fun onClicked(posture: Posture)
}