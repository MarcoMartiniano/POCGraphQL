package com.marco.pocgraphql

import android.app.Application
import com.marco.pocgraphql.di.dataModule
import com.marco.pocgraphql.di.dataRemoteModule
import com.marco.pocgraphql.di.presentationModule
import com.marco.pocgraphql.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    dataModule,
                    dataRemoteModule,
                    useCaseModule,
                    presentationModule
                )
            )
        }
    }
}