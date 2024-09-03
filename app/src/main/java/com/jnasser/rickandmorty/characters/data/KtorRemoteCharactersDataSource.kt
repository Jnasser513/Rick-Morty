package com.jnasser.rickandmorty.characters.data

import com.jnasser.rickandmorty.characters.domain.RemoteCharactersDataSource
import com.jnasser.rickandmorty.core.data.network.ApiConstants
import com.jnasser.rickandmorty.core.data.network.get
import com.jnasser.rickandmorty.core.domain.character.CharacterResult
import com.jnasser.rickandmorty.core.domain.util.DataError
import com.jnasser.rickandmorty.core.domain.util.EmptyResult
import com.jnasser.rickandmorty.core.domain.util.Result
import com.jnasser.rickandmorty.core.domain.util.map
import io.ktor.client.HttpClient

class KtorRemoteCharactersDataSource(
    val ktorClient: HttpClient
): RemoteCharactersDataSource {

    override suspend fun getCharacters(): Result<CharacterResult, DataError.Network> {
        return ktorClient.get<CharacterResultDto>(
            route = ApiConstants.CHARACTERS_ROUTE
        ).map { it.toCharacterResult() }
    }
}