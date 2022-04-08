package ir.moris.cripotoid.domain.repositorie

import ir.moris.cripotoid.data.remote.dto.CryptoDetailDto
import ir.moris.cripotoid.data.remote.dto.CryptoDto

interface CryptoRepository {
    suspend fun getCryptos(): List<CryptoDto>
    suspend fun getCryptoById(coinId : String) : CryptoDetailDto
}