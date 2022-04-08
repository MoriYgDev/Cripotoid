package ir.moris.cripotoid.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.moris.cripotoid.common.Constants.BASE_URL
import ir.moris.cripotoid.data.remote.CoinPaprikaApi
import ir.moris.cripotoid.data.repository.CryptoRepositoryImpl
import ir.moris.cripotoid.domain.repositorie.CryptoRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CryptoRepository {
        return CryptoRepositoryImpl(api)
    }

}