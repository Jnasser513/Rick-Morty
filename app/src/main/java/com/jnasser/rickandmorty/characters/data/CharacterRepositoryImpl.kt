package com.jnasser.rickandmorty.characters.data

import com.jnasser.rickandmorty.characters.domain.CharactersRepository
import com.jnasser.rickandmorty.core.domain.character.CharacterResult
import com.jnasser.rickandmorty.core.domain.util.DataError
import com.jnasser.rickandmorty.core.domain.util.Result
import kotlinx.coroutines.CoroutineScope

class CharacterRepositoryImpl(
    private val ktorRemoteCharactersDataSource: KtorRemoteCharactersDataSource
): CharactersRepository {

    override suspend fun getRemoteCharacters(): Result<CharacterResult, DataError.Network> {
        return when(val result = ktorRemoteCharactersDataSource.getCharacters()) {
            is Result.Error -> Result.Error(result.error)
            is Result.Success -> Result.Success(result.data)
        }
    }
}