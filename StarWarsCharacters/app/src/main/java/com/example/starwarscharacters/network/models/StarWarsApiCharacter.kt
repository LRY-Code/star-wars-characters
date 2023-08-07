package com.example.starwarscharacters.network.models

import com.squareup.moshi.Json

data class StarWarsApiCharacter(
    val name: String,
    @field:Json(name = "birth_year")
    val birthYear: String,
    val height: Int,
    val mass: Int,
    val gender: String,
)