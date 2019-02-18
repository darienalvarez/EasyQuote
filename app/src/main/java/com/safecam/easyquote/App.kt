package com.safecam.easyquote

import android.app.Application
import com.safecam.easyquote.view.di.DependencyProvider
import org.koin.android.ext.android.startKoin

/**
 * @author Darien
 */
class App : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin(this, DependencyProvider.modules)
    }


}