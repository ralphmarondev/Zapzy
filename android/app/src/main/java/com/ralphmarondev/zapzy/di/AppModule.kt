package com.ralphmarondev.zapzy.di

import com.ralphmarondev.zapzy.MainViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val appModule = module {
    factoryOf(::MainViewModel)
}