package com.tallaltasawar.showcase.domain.usecase

import com.tallaltasawar.showcase.common.Resource
import com.tallaltasawar.showcase.data.dto.toCryptoCurrency
import com.tallaltasawar.showcase.domain.model.CryptoCurrency
import com.tallaltasawar.showcase.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCurrenciesUseCase @Inject constructor(
    // This can be mocked at the tests later hence the interface
    private val repository: CurrencyRepository
) {
    operator fun invoke(): Flow<Resource<List<CryptoCurrency>>> = flow {
        try {
            emit(Resource.Loading<List<CryptoCurrency>>())
            emit(Resource.Success<List<CryptoCurrency>>(repository.getCurrencies().map { it.toCryptoCurrency() }))
        }
        catch (e: HttpException) {
            emit(Resource.Failure<List<CryptoCurrency>>(e.localizedMessage))
        }
        catch (e: IOException) {
            emit(Resource.Failure<List<CryptoCurrency>>(e.localizedMessage))
        }
    }

}