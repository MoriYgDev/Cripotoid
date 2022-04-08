package ir.moris.cripotoid.data.repository

import ir.moris.cripotoid.data.remote.CoinPaprikaApi
import ir.moris.cripotoid.data.remote.dto.CryptoDetailDto
import ir.moris.cripotoid.data.remote.dto.CryptoDto
import ir.moris.cripotoid.domain.repositorie.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
) : CryptoRepository{
    override suspend fun getCryptos(): List<CryptoDto> {
       return api.getCryptos()
    }

    override suspend fun getCryptoById(coinId: String): CryptoDetailDto {
        return api.getCryptoById(coinId)
    }
}