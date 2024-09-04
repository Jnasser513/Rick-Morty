package com.jnasser.rickandmorty.characters.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jnasser.rickandmorty.BuildConfig
import com.jnasser.rickandmorty.R
import com.jnasser.rickandmorty.characters.presentation.model.CharacterDataUi
import com.jnasser.rickandmorty.core.domain.character.Character
import com.jnasser.rickandmorty.core.presentation.designsystem.FavoriteIcon
import com.jnasser.rickandmorty.core.presentation.designsystem.RickAndMortyTheme
import com.jnasser.rickandmorty.core.presentation.designsystem.components.Image
import kotlin.math.max

@Composable
fun CharacterListItem(
    character: Character,
    onFavoriteClick: (Boolean) -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val imageUrl = BuildConfig.BASE_URL + "/character/avatar/${character.id}.jpeg"

    Box {
        Column(
            modifier = modifier
                .clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .clickable { onClick() }
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ) {
                IconButton(onClick = { onFavoriteClick(true) }) {
                    Icon(
                        imageVector = FavoriteIcon,
                        contentDescription = stringResource(id = R.string.favorite),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Image(imageUrl = imageUrl)
            NameSection(name = character.name)
            DataGrid(character = character)
        }
    }
}

@Composable
private fun NameSection(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun DataGrid(
    character: Character,
    modifier: Modifier = Modifier
) {
    val runDataUiList = listOf(
        CharacterDataUi(
            name = stringResource(id = R.string.status),
            value = character.status
        ),
        CharacterDataUi(
            name = stringResource(id = R.string.species),
            value = character.species
        ),
        CharacterDataUi(
            name = stringResource(id = R.string.type),
            value = character.type
        ),
        CharacterDataUi(
            name = stringResource(id = R.string.gender),
            value = character.gender
        )
    )
    var maxWidth by remember {
        mutableIntStateOf(0)
    }
    val maxWidthDp = with(LocalDensity.current) {
        maxWidth.toDp()
    }
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        runDataUiList.forEach { run ->
            DataGridCell(
                runData = run,
                modifier = Modifier
                    .defaultMinSize(minWidth = maxWidthDp)
                    .onSizeChanged {
                        maxWidth = max(maxWidth, it.width)
                    }
            )
        }
    }
}

@Composable
private fun DataGridCell(
    runData: CharacterDataUi,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = runData.name,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = runData.value,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview
@Composable
private fun CharacterListItemPreview() {
    RickAndMortyTheme {
        CharacterListItem(
            character = Character(1, "Rick", "available", "", "", ""),
            onFavoriteClick = { },
            onClick = { })
    }
}