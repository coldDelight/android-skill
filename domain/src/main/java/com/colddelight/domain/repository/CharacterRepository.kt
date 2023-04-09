package com.colddelight.domain.repository

import com.colddelight.domain.model.DomainCharacterInfo

interface CharacterRepository {
    suspend fun getCharacterInfo(): List<DomainCharacterInfo>

    suspend fun saveCharacterInfo(characterInfo: DomainCharacterInfo)

    suspend fun getMyCharacterInfo(): List<DomainCharacterInfo>
}