package com.jnasser.rickandmorty.characters.domain

import com.jnasser.rickandmorty.characters.data.CharacterResultDto
import com.jnasser.rickandmorty.core.domain.character.CharacterResult
import com.jnasser.rickandmorty.core.domain.util.DataError
import com.jnasser.rickandmorty.core.domain.util.EmptyResult
import com.jnasser.rickandmorty.core.domain.util.Result

interface RemoteCharactersDataSource {

    suspend fun getCharacters(): Result<CharacterResult, DataError.Network>
}