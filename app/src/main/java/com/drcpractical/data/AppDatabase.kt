package com.drcpractical.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [TransactionModel::class], version = 1, exportSchema = false)
open abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao

}