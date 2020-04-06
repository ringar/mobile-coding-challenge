package com.daniel.farre.yogasolotest.presentation

import com.daniel.farre.yogasolotest.data.PosturesRepository
import com.daniel.farre.yogasolotest.data.remote.PosturesApi
import com.daniel.farre.yogasolotest.data.remote.RemotePosturesRepository
import com.daniel.farre.yogasolotest.domain.PostureMapper
import com.daniel.farre.yogasolotest.domain.PosturesService
import com.daniel.farre.yogasolotest.presentation.GlobalConstants.Companion.IP
import com.daniel.farre.yogasolotest.presentation.detail.PostureDetailViewModel
import com.daniel.farre.yogasolotest.presentation.list.PosturesViewModel
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


var koinPosturesModule = module {

    single {
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }
    single {
        Retrofit
            .Builder()
            .baseUrl(IP)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }
    single { get<Retrofit>().create(PosturesApi::class.java) }
    single { RemotePosturesRepository(get(), get()) }
    single { PosturesRepository(get()) }
    single { PostureMapper() }
    single { PosturesService(get()) }
    viewModel { PostureDetailViewModel(get()) }
    viewModel { PosturesViewModel(get()) }
}