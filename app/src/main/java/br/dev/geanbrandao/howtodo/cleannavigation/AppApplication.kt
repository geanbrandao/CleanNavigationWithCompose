package br.dev.geanbrandao.howtodo.cleannavigation

import android.app.Application
import br.dev.geanbrandao.howtodo.cleannavigation.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.*

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            modules(
                listOf(AppModule().module)
            )
        }
    }
}