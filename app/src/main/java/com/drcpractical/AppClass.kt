package com.drcpractical

import com.drcpractical.di.component.DaggerAppComponent
import dagger.android.DaggerApplication

open class AppClass : DaggerApplication() {
    private val appComponent = DaggerAppComponent.factory().create(this)

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun applicationInjector() = appComponent
}