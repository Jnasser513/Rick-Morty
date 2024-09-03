package com.jnasser.rickandmorty.characters.domain

import com.jnasser.rickandmorty.core.domain.character.CharacterResult
import com.jnasser.rickandmorty.core.domain.util.DataError
import com.jnasser.rickandmorty.core.domain.util.Result

interface CharactersRepository {

    suspend fun getRemoteCharacters(): Result<CharacterResult, DataError.Network>
}