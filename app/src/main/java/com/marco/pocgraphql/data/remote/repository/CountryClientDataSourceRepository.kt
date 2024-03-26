package com.marco.pocgraphql.data.remote.repository

import com.marco.pocgraphql.domain.models.DetailedCountry
import com.marco.pocgraphql.domain.models.SimpleCountry

interface CountryClientDataSourceRepository {

    suspend fun getCountries(): List<SimpleCountry>
    suspend fun getCountry(code: String): DetailedCountry?
}