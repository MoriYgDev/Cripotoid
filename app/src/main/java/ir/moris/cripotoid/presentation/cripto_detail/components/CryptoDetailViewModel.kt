package ir.moris.cripotoid.presentation.cripto_detail.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.moris.cripotoid.common.Constants.PARAM_COIN_ID
import ir.moris.cripotoid.common.Resource
import ir.moris.cripotoid.domain.use_cases.get_cripto.GetCryptoUseCase
import ir.moris.cripotoid.presentation.cripto_detail.CryptoDetailState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val getCryptoUseCase: GetCryptoUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CryptoDetailState())
    val state: State<CryptoDetailState> = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCrypto(coinId)
        }
    }

    private fun getCrypto(coinId: String) {
        getCryptoUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CryptoDetailState(cryptos = result.data)
                }
                is Resource.Loading -> {
                    _state.value = CryptoDetailState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value =
                        CryptoDetailState(error = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }

}