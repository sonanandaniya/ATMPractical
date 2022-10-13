package com.drcpractical.di.module

import com.drcpractical.ui.MainActivity
import com.drcpractical.di.annotation.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity
}