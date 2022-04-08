package ir.moris.cripotoid.data.remote

import ir.moris.cripotoid.data.remote.dto.CryptoDetailDto
import ir.moris.cripotoid.data.remote.dto.CryptoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCryptos() : List<CryptoDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCryptoById(@Path("coinId") coinId : String) : CryptoDetailDto

}