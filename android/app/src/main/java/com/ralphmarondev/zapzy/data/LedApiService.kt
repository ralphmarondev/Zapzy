package com.ralphmarondev.zapzy.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface LedApiService {

    @GET("leds/")
    suspend fun getLeds(): List<LedDto>

    @PATCH("led/on/{id}/")
    suspend fun turnOnLed(@Path("id") id: Int): Response<Unit>

    @PATCH("led/off/{id}/")
    suspend fun turnOffLed(@Path("id") id: Int): Response<Unit>
}