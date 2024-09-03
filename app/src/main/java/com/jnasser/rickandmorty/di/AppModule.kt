package com.jnasser.rickandmorty.di

import com.jnasser.rickandmorty.RickAndMortyApp
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single<CoroutineScope> {
        (androidApplication() as RickAndMortyApp).applicationScope
    }
}