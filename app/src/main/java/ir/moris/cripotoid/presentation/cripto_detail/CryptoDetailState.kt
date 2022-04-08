package ir.moris.cripotoid.presentation.cripto_detail


import ir.moris.cripotoid.domain.model.CryptoDetail

data class CryptoDetailState(
    val isLoading: Boolean = false,
    val cryptos: CryptoDetail? = null,
    val error: String = ""
)
