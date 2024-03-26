package com.marco.pocgraphql.di


import com.marco.pocgraphql.domain.core.ThreadContextProvider
import com.marco.pocgraphql.domain.interactor.GetCountriesUseCase
import com.marco.pocgraphql.domain.interactor.GetCountryUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single {
        ThreadContextProvider()
    }

    factory { GetCountriesUseCase(get(), get()) }
    factory { GetCountryUseCase(get(), get()) }

}