package com.colddelight.data.remote.dataSourceImpl

import com.colddelight.data.remote.dataSource.CharacterDataSource
import com.colddelight.data.remote.dto.CharacterInfoDto
import retrofit2.Retrofit
import javax.inject.Inject

class CharacterDataSourceImpl @Inject constructor(
    private val retrofit: Retrofit
) : CharacterDataSource {
    override suspend fun getCharacterInfo(): CharacterInfoDto {
        return retrofit.create(CharacterDataSource::class.java).getCharacterInfo()
    }
}