package com.marco.pocgraphql.di

import com.apollographql.apollo3.ApolloClient
import com.marco.pocgraphql.data.remote.datasource.CountryClientRepositoryImpl
import com.marco.pocgraphql.domain.repository.CountryClientRepository
import org.koin.dsl.module

val dataRemoteModule = module {

    single {
        ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    single<CountryClientRepository> { CountryClientRepositoryImpl(get()) }
}