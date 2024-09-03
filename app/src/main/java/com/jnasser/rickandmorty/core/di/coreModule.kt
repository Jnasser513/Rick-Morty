package com.jnasser.rickandmorty.core.di

import com.jnasser.rickandmorty.core.data.network.HttpClientFactory
import org.koin.dsl.module

val coreModule = module {
    single {
        HttpClientFactory().build()
    }
}