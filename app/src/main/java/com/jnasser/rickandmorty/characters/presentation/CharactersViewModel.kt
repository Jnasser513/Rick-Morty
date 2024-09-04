package com.jnasser.rickandmorty.characters.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jnasser.rickandmorty.characters.domain.CharactersRepository
import com.jnasser.rickandmorty.core.domain.util.Result
import com.jnasser.rickandmorty.core.domain.util.map
import kotlinx.coroutines.launch
import timber.log.Timber

class CharactersViewModel(
    private val charactersRepository: CharactersRepository
): ViewModel() {

    var state by mutableStateOf(CharacterListViewState())
        private set

    init {
        viewModelScope.launch {
            val result = charactersRepository.getRemoteCharacters().map { it.results }
            state = when(result) {
                is Result.Error -> state.copy(isLoading = false)
                is Result.Success -> state.copy(isLoading = false, characters = result.data)
            }
        }
    }

    fun onAction(action: CharacterListAction) {
        when(action) {
            is CharacterListAction.OnFavoriteClick -> {
                // TODO("Ejecutar funcion para agregar a favoritos en base local")
            }
            CharacterListAction.UnFavoriteAction -> {
                // TODO("Ejecutar funcion para eliminar de favoritos en base local)
            }
            else -> Unit
        }
    }
}