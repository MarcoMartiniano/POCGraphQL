package com.marco.pocgraphql.di

import com.marco.pocgraphql.presentation.CountriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CountriesViewModel() }
}