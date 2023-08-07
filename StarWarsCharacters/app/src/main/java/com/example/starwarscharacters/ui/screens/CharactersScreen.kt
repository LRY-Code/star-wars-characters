package com.example.starwarscharacters.ui.screens;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.starwarscharacters.network.models.StarWarsApiCharacter

@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier,
    viewModel: CharactersScreenViewModel = CharactersScreenViewModel(),
) {
    val characters by viewModel.characters.observeAsState()

    characters?.let {
        LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
            items(items = it) { character ->
                CharacterCard(character = character)
            }
        }
    } ?: run {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            CircularProgressIndicator(modifier = Modifier.size(80.dp).padding(5.dp))
            Text(text = "Loading Characters")
        }
    }
}

@Composable
private fun CharacterCard(character: StarWarsApiCharacter) {
    Card(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CharacterCardContent(character)
    }
}

@Composable
private fun CharacterCardContent(character: StarWarsApiCharacter) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(
                text = character.name,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanded) {
                Column {
                    Text(text = "Gender: ${character.gender}")
                    Text(text = "Birth Year: ${character.birthYear}")
                    Text(text = "Height: ${character.height}")
                    Text(text = "Mass: ${character.mass}")
                }
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = null
            )
        }
    }
}