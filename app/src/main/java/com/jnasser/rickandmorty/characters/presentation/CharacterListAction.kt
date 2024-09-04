package com.jnasser.rickandmorty.characters.presentation

import com.jnasser.rickandmorty.core.domain.character.Character

sealed interface CharacterListAction {
    data object OnCharacterClick: CharacterListAction
    data class OnFavoriteClick(val character: Character): CharacterListAction
    data object UnFavoriteAction: CharacterListAction
}