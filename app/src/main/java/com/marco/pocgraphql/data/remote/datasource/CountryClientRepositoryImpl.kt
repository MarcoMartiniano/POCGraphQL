package com.marco.pocgraphql.data.remote.datasource

import com.marco.pocgraphql.data.remote.repository.CountryClientDataSourceRepository
import com.marco.pocgraphql.domain.models.DetailedCountry
import com.marco.pocgraphql.domain.models.SimpleCountry
import com.marco.pocgraphql.domain.repository.CountryClientRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CountryClientRepositoryImpl(
    private val repository: CountryClientDataSourceRepository,
) : CountryClientRepository {
    override fun getCountries(): Flow<List<SimpleCountry>> = flow {
        emit(repository.getCountries())
    }

    override fun getCountry(code: String): Flow<DetailedCountry?> = flow {
        emit(repository.getCountry(code = code))
    }
}