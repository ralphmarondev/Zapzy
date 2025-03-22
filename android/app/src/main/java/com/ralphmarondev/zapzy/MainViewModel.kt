package com.ralphmarondev.zapzy

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _ledStatus = MutableStateFlow(false)
    val ledStatus = _ledStatus.asStateFlow()

    fun toggleLed() {
        _ledStatus.value = !_ledStatus.value
    }
}