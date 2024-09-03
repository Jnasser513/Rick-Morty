package com.jnasser.rickandmorty.characters.di

import com.jnasser.rickandmorty.characters.data.CharacterRepositoryImpl
import com.jnasser.rickandmorty.characters.data.KtorRemoteCharactersDataSource
import com.jnasser.rickandmorty.characters.domain.CharactersRepository
import com.jnasser.rickandmorty.characters.domain.RemoteCharactersDataSource
import com.jnasser.rickandmorty.characters.presentation.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val charactersModule = module {
    singleOf(::KtorRemoteCharactersDataSource).bind<RemoteCharactersDataSource>()
    singleOf(::CharacterRepositoryImpl).bind<CharactersRepository>()

    viewModelOf(::CharactersViewModel)
}