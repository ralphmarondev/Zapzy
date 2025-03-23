package com.ralphmarondev.zapzy.di

import com.ralphmarondev.zapzy.MainViewModel
import com.ralphmarondev.zapzy.data.LedApiService
import com.ralphmarondev.zapzy.data.LedRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://192.168.68.108:8000/api/"

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LedApiService::class.java)
    }
    single { LedRepository(get()) }

    factoryOf(::MainViewModel)
}