package com.colddelight.data.remote.dataSource

import com.colddelight.data.remote.dto.CharacterInfoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterDataSource {

    @GET("character")
    suspend fun getCharacterInfo(): CharacterInfoDto
}