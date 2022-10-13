package com.drcpractical.di.component

import android.app.Application
import com.drcpractical.di.module.ActivityModule
import com.drcpractical.di.module.ViewModelModule
import com.drcpractical.di.module.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, ActivityModule::class, ViewModelModule::class, DataModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}