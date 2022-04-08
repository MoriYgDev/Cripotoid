package ir.moris.cripotoid.presentation.cripto_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.moris.cripotoid.common.Resource
import ir.moris.cripotoid.domain.use_cases.get_criptoes.GetCryptosUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val getCryptosUseCase: GetCryptosUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CryptoListState())
    val state: State<CryptoListState> = _state

    init {
        getCryptos()
    }

    private fun getCryptos() {
        getCryptosUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CryptoListState(cryptos = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = CryptoListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value =
                        CryptoListState(error = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }

}