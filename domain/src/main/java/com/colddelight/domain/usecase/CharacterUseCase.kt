package com.colddelight.domain.usecase

import com.colddelight.domain.model.DomainCharacterInfo
import com.colddelight.domain.repository.CharacterRepository

class CharacterUseCase(private val repository: CharacterRepository) {
    suspend operator fun invoke(): List<DomainCharacterInfo> {
        return repository.getCharacterInfo()
    }

    suspend fun saveCharacter(characterInfo: DomainCharacterInfo) {
        return repository.saveCharacterInfo(characterInfo)
    }

    suspend fun getMyCharacter(): List<DomainCharacterInfo> {
        return repository.getMyCharacterInfo()
    }
}