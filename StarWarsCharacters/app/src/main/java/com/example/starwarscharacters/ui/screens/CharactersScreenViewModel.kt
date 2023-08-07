package com.example.starwarscharacters.ui.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarscharacters.network.StarWarsApi
import com.example.starwarscharacters.network.models.StarWarsApiCharacter
import kotlinx.coroutines.launch

class CharactersScreenViewModel : ViewModel() {
    var characters = MutableLiveData<List<StarWarsApiCharacter>>()

    init {
        viewModelScope.launch {
            characters.value = StarWarsApi().starWarsApiService.getCharacters().results
        }
    }
}