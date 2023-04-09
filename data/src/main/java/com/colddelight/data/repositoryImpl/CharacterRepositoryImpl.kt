package com.colddelight.data.repositoryImpl

import com.colddelight.data.local.dao.CharacterDAO
import com.colddelight.data.local.entity.CharacterEntity
import com.colddelight.data.remote.dataSource.CharacterDataSource
import com.colddelight.data.remote.dto.toDomainCharacterInfo
import com.colddelight.domain.model.DomainCharacterInfo
import com.colddelight.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: CharacterDataSource,
    private val dao: CharacterDAO
) : CharacterRepository {
    override suspend fun getCharacterInfo(): List<DomainCharacterInfo> {
        return api.getCharacterInfo().toDomainCharacterInfo()
    }

    override suspend fun saveCharacterInfo(characterInfo: DomainCharacterInfo) {
        val saveData = characterInfo.imageLocal?.let {
            CharacterEntity(characterInfo.name, characterInfo.species, it)
        }
        if (saveData != null) {
            dao.insetCharacter(saveData)
        }
    }

    override suspend fun getMyCharacterInfo(): List<DomainCharacterInfo> {
        return dao.getCharacter().map { it.toDomainCharacterInfo() }
    }
}