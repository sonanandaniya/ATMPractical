package com.drcpractical.di.module

import android.app.Application
import androidx.room.Room
import com.drcpractical.data.AppDatabase
import com.drcpractical.data.TransactionDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "transaction_db"
    ).allowMainThreadQueries().build()

    @Provides
    @Singleton
    fun provideTransactionDao(database: AppDatabase): TransactionDao = database.transactionDao()
}