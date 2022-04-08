package ir.moris.cripotoid.presentation.cripto_list

import ir.moris.cripotoid.domain.model.Crypto

data class CryptoListState(
    val isLoading: Boolean = false,
    val cryptos: List<Crypto> = emptyList(),
    val error: String = ""
)
