package com.drcpractical.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
abstract class TransactionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun addTransaction(transaction: TransactionModel): Long

    @Query("SELECT * FROM transactionTable ORDER BY transaction_id DESC LIMIT 5")
    abstract fun getTransaction(): LiveData<List<TransactionModel>>
}