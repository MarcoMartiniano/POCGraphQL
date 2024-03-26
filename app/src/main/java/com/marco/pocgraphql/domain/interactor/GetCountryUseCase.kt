package com.marco.pocgraphql.domain.interactor

import com.marco.pocgraphql.domain.core.UseCase
import com.marco.pocgraphql.domain.models.DetailedCountry
import com.marco.pocgraphql.domain.repository.CountryClientRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetCountryUseCase(
    scope: CoroutineScope,
    private val repository: CountryClientRepository,
) : UseCase<DetailedCountry?, GetCountryUseCase.Params>(scope) {

    data class Params(
        val code: String,
    )

    override fun run(params: Params?): Flow<DetailedCountry?> =
        repository.getCountry(code = params?.code ?: "")
}