package com.colddelight.data.remote.dto

import com.colddelight.domain.model.DomainCharacterInfo

data class CharacterInfoDto(
    val info: Info,
    val results : List<Character>
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String,
)
data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Detail,
    val location: Detail,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String,
)

data class Detail(
    val name: String,
    val url: String,
)

fun CharacterInfoDto.toDomainCharacterInfo(): List<DomainCharacterInfo> {
    return results.map { DomainCharacterInfo(it.name,it.species,it.image) }
}