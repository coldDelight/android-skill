package com.colddelight.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.colddelight.domain.model.DomainCharacterInfo

@Entity(tableName = "character")
data class CharacterEntity(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "species") val species: String,
    @ColumnInfo(name = "image") val image: ByteArray,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    ) {
    fun toDomainCharacterInfo(): DomainCharacterInfo {
        return DomainCharacterInfo(
            name = name,
            species = species,
            imageLocal = image
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CharacterEntity

        if (name != other.name) return false
        if (species != other.species) return false
        if (!image.contentEquals(other.image)) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + species.hashCode()
        result = 31 * result + image.contentHashCode()
        result = 31 * result + id
        return result
    }
}