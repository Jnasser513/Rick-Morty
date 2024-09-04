package com.jnasser.rickandmorty.characters.presentation

import com.jnasser.rickandmorty.core.domain.character.Character

data class CharacterListViewState(
    val isLoading: Boolean = true,
    val characters: List<Character> = emptyList()
)
