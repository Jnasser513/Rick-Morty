package com.jnasser.rickandmorty

import android.app.Application
import android.content.Context
import com.jnasser.rickandmorty.characters.di.charactersModule
import com.jnasser.rickandmorty.core.di.coreModule
import com.jnasser.rickandmorty.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RickAndMortyApp: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RickAndMortyApp)
            modules(
                appModule,
                coreModule,
                charactersModule
            )
        }
    }
}