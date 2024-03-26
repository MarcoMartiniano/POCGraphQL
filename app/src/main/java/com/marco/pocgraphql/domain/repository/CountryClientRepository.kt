package com.marco.pocgraphql.domain.repository

import com.marco.pocgraphql.domain.models.DetailedCountry
import com.marco.pocgraphql.domain.models.SimpleCountry
import kotlinx.coroutines.flow.Flow

interface CountryClientRepository {
    fun getCountries(): Flow<List<SimpleCountry>>
    fun getCountry(code: String): Flow<DetailedCountry?>
}