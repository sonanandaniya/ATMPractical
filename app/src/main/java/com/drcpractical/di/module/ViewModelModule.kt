package com.drcpractical.di.module

import androidx.lifecycle.ViewModel
import com.drcpractical.di.annotation.ViewModelKey
import com.drcpractical.viewModels.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun bindHomeActivityViewModels(homeActivityViewModel: HomeViewModel): ViewModel
}
