package com.marco.pocgraphql.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.marco.pocgraphql.domain.interactor.GetCountriesUseCase
import com.marco.pocgraphql.domain.interactor.GetCountryUseCase
import com.marco.pocgraphql.domain.models.DetailedCountry
import com.marco.pocgraphql.domain.models.SimpleCountry
import com.marco.pocgraphql.utils.useCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent


class CountriesViewModel : ViewModel(), KoinComponent {

    private val getCountriesUseCase: GetCountriesUseCase by useCase()
    private val getCountryUseCase: GetCountryUseCase by useCase()


    private val _state = MutableStateFlow(CountriesState())
    val state = _state.asStateFlow()

    init {
        getCountriesUseCase()
        _state.update {
            it.copy(
                isLoading = true
            )
        }
    }

    private fun getCountriesUseCase() {
        getCountriesUseCase(
            params = Unit,
            onSuccess = { result ->
                _state.update {
                    it.copy(
                        countries = result,
                        isLoading = false
                    )
                }
            },
            onError = {
                Log.e("Error", it.message.toString())
            }
        )
    }

    fun getCountryUseCase(code: String) {
        getCountryUseCase(
            params = GetCountryUseCase.Params(code = code),
            onSuccess = { result ->
                _state.update {
                    it.copy(
                        selectedCountry = result
                    )
                }
            },
            onError = {
                Log.e("Error", it.message.toString())
            }
        )
    }


    fun dismissCountryDialog() {
        _state.update {
            it.copy(
                selectedCountry = null
            )
        }
    }

    data class CountriesState(
        val countries: List<SimpleCountry> = emptyList(),
        val isLoading: Boolean = false,
        val selectedCountry: DetailedCountry? = null,
    )
}