package com.daniel.farre.yogasolotest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daniel.farre.yogasolotest.R
import com.daniel.farre.yogasolotest.presentation.list.PosturesFragment
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PosturesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startKoin {
            androidContext(this@PosturesActivity)
        }
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PosturesFragment())
                .commitNow()
        }
    }
}
