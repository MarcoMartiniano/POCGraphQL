package com.marco.pocgraphql.di

import com.marco.pocgraphql.data.remote.repository.CountryClientDataSourceRepository
import com.marco.pocgraphql.data_remote.datasource.CountryClientDataSourceRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<CountryClientDataSourceRepository> { CountryClientDataSourceRepositoryImpl(get()) }
}