package com.jnasser.rickandmorty

import android.app.Application
import android.content.Context
import org.koin.core.context.startKoin

class RickAndMortyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

        }
    }
}