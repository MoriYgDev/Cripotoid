package ir.moris.cripotoid.data.remote.dto

import com.google.gson.annotations.SerializedName
import ir.moris.cripotoid.domain.model.Crypto

data class CryptoDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CryptoDto.toCrypto(): Crypto {
    return Crypto(
        id, isActive, name, rank, symbol
    )
}