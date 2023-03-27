package com.tallaltasawar.showcase

import com.tallaltasawar.showcase.dispatcher.MainDispatcherRule
import com.tallaltasawar.showcase.domain.usecase.GetCurrenciesUseCase
import com.tallaltasawar.showcase.mock.MockCurrencyRepository
import com.tallaltasawar.showcase.presentation.viewmodel.crypto_currencies.CryptoCurrenciesViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CurrencyListViewModelTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val defaultCurrencyRepository = MockCurrencyRepository()
    private val getCurrenciesUseCase = GetCurrenciesUseCase(defaultCurrencyRepository)
    private lateinit var viewmodel: CryptoCurrenciesViewModel

    @Before
    fun setup() {
        viewmodel = CryptoCurrenciesViewModel(getCurrenciesUseCase)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun checkIfLoadingIsNotShownInitially() = runTest {
        getCurrenciesUseCase.invoke()
        assert(!viewmodel.state.value.loading)
    }

    //If loading is show initially
}


