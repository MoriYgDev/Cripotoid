package ir.moris.cripotoid.domain.use_cases.get_criptoes

import ir.moris.cripotoid.common.Resource
import ir.moris.cripotoid.data.remote.dto.toCrypto
import ir.moris.cripotoid.domain.model.Crypto
import ir.moris.cripotoid.domain.repositorie.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCryptosUseCase @Inject constructor(
    private val repository: CryptoRepository
){

    operator fun invoke(): Flow<Resource<List<Crypto>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val cryptos = repository.getCryptos().map { it.toCrypto() }
                emit(Resource.Success(cryptos))
            }catch (e : HttpException){
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
            }catch (e : IOException){
                emit(Resource.Error("couldn't reach server. check your internet connection"))
            }
        }
    }

}