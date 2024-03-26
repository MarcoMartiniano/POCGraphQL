package com.marco.pocgraphql.data_remote.datasource

import com.apollographql.apollo3.ApolloClient
import com.marco.CountriesQuery
import com.marco.CountryQuery
import com.marco.pocgraphql.data.remote.repository.CountryClientDataSourceRepository
import com.marco.pocgraphql.data_remote.mappers.toDetailedCountry
import com.marco.pocgraphql.data_remote.mappers.toSimpleCountry
import com.marco.pocgraphql.domain.models.DetailedCountry
import com.marco.pocgraphql.domain.models.SimpleCountry

class CountryClientDataSourceRepositoryImpl(
    private val apolloClient: ApolloClient,
) : CountryClientDataSourceRepository {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}