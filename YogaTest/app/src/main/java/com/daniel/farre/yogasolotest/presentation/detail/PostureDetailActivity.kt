package com.daniel.farre.yogasolotest.presentation.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daniel.farre.yogasolotest.R
import com.daniel.farre.yogasolotest.presentation.GlobalConstants.Companion.ID_EXTRAS

class PostureDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val id = intent.getStringExtra(ID_EXTRAS)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PostureDetailFragment(id))
                .commitNow()
        }
    }
}
