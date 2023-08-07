package com.example.starwarscharacters.network

import com.example.starwarscharacters.network.models.StarWarsApiCharactersResult
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


private const val BASE_URL = "https://swapi.dev/api/"


class StarWarsApiClient {

    fun getClient(): Retrofit {
        val client = OkHttpClient.Builder().apply {
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            connectTimeout(60, TimeUnit.SECONDS)
        }.build()
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
}

interface StarWarsApiService {
    @GET("people")
    suspend fun getCharacters(): StarWarsApiCharactersResult
}
