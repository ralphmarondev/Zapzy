package com.ralphmarondev.zapzy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.zapzy.data.LedRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: LedRepository
) : ViewModel() {

    private val _ledStatus = MutableStateFlow(false)
    val ledStatus = _ledStatus.asStateFlow()

    init {
        viewModelScope.launch {
            val leds = repository.getLeds()
            leds.find { it.id == 1 }?.let {
                _ledStatus.value = it.status
            }
        }
    }

    fun toggleLed() {
        viewModelScope.launch {
            val newStatus = !_ledStatus.value
            _ledStatus.value = newStatus
            if (newStatus) {
                repository.turnOnLed(1)
            } else {
                repository.turnOffLed(1)
            }
            _ledStatus.value = newStatus
        }
    }
}