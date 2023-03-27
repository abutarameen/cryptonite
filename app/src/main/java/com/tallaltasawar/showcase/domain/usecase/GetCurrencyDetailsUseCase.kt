package com.tallaltasawar.showcase.domain.usecase

import androidx.lifecycle.SavedStateHandle
import com.tallaltasawar.showcase.common.Resource
import com.tallaltasawar.showcase.data.dto.toCurrencyDetail
import com.tallaltasawar.showcase.domain.model.CurrencyDetail
import com.tallaltasawar.showcase.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCurrencyDetailsUseCase @Inject constructor(
    // This can be mocked at the tests later hence the interface
    private val repository: CurrencyRepository
) {
    operator fun invoke(currencyId: String): Flow<Resource<CurrencyDetail>> = flow {
        try {
            emit(Resource.Loading<CurrencyDetail>())
            emit(Resource.Success<CurrencyDetail>(repository.getCurrencyDetails(currencyId).toCurrencyDetail()))
        }
        catch (e: HttpException) {
            emit(Resource.Failure<CurrencyDetail>(e.localizedMessage))
        }
        catch (e: IOException) {
            emit(Resource.Failure<CurrencyDetail>(e.localizedMessage))
        }
    }

}