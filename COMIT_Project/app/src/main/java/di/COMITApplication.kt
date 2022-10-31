package di

import android.app.Application
import di.module.myDiModule
import org.koin.core.context.startKoin

class COMITApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(applicationContext, myDiModule)
    }
}

