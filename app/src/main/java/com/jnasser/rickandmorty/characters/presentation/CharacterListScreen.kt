package com.jnasser.rickandmorty.characters.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jnasser.rickandmorty.characters.presentation.components.CharacterListItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterListScreenRot(
    viewModel: CharactersViewModel = koinViewModel()
) {
    CharacterListScreen(
        state = viewModel.state,
        onAction = { action ->
            when(action) {
                CharacterListAction.OnCharacterClick -> {
                    // TODO("Redirigir a detalle de personaje")
                }
                else -> viewModel.onAction(action)
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CharacterListScreen(
    state: CharacterListViewState,
    onAction: (CharacterListAction) -> Unit
) {
    if(state.isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),

        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center),
                strokeWidth = 2.dp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(rememberNestedScrollInteropConnection())
                .padding(horizontal = 16.dp)
                .padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items = state.characters, key = { it.id }) { character ->
                CharacterListItem(
                    character = character,
                    onFavoriteClick = { onAction(CharacterListAction.OnFavoriteClick(character)) },
                    onClick = { onAction(CharacterListAction.OnCharacterClick) },
                    modifier = Modifier.animateItemPlacement()
                )
            }
        }
    }
}

@Preview
@Composable
private fun CharacterListScreenPreview() {
    CharacterListScreen(state = CharacterListViewState(), onAction = {})
}