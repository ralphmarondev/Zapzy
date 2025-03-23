package com.ralphmarondev.zapzy.data

class LedRepository(
    private val apiService: LedApiService
) {
    suspend fun getLeds() = apiService.getLeds()
    suspend fun turnOnLed(id: Int) = apiService.turnOnLed(id)
    suspend fun turnOffLed(id: Int) = apiService.turnOffLed(id)
}