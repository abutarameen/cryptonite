package com.tallaltasawar.showcase.di

import com.tallaltasawar.showcase.common.Constants
import com.tallaltasawar.showcase.data.remote.CryptoAPI
import com.tallaltasawar.showcase.data.repossitory.DefaultCurrencyRepository
import com.tallaltasawar.showcase.domain.repository.CurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Cryptocurrency web API using retrofit
    @Provides
    @Singleton
    fun provideCryptoCurrencyAPI(): CryptoAPI = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CryptoAPI::class.java)

    //Currency repository
    @Provides
    @Singleton
    fun provideCurrencyRepository(api: CryptoAPI): CurrencyRepository = DefaultCurrencyRepository(api)
}