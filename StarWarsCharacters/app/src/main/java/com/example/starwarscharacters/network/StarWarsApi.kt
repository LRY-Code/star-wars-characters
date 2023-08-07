package com.example.starwarscharacters.network

class StarWarsApi {
    val starWarsApiService: StarWarsApiService by lazy {
        StarWarsApiClient().getClient().create(StarWarsApiService::class.java)
    }
}