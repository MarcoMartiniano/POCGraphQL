package com.marco.pocgraphql.domain.interactor

import com.marco.pocgraphql.domain.core.UseCase
import com.marco.pocgraphql.domain.repository.CountryClientRepository
import com.marco.pocgraphql.domain.models.SimpleCountry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetCountriesUseCase(
    scope: CoroutineScope,
    private val repository: CountryClientRepository,
) : UseCase<List<SimpleCountry>, Unit>(scope) {

    override fun run(params: Unit?): Flow<List<SimpleCountry>> = repository.getCountries()
}