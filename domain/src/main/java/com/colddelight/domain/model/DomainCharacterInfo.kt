package com.colddelight.domain.model

data class DomainCharacterInfo(
    val name: String,
    val species: String,
    val image: String? = null,
    val imageLocal: ByteArray? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DomainCharacterInfo

        if (name != other.name) return false
        if (species != other.species) return false
        if (image != other.image) return false
        if (imageLocal != null) {
            if (other.imageLocal == null) return false
            if (!imageLocal.contentEquals(other.imageLocal)) return false
        } else if (other.imageLocal != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + species.hashCode()
        result = 31 * result + image.hashCode()
        result = 31 * result + (imageLocal?.contentHashCode() ?: 0)
        return result
    }
}