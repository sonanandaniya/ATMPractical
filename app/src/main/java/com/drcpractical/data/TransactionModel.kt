package com.drcpractical.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactionTable")
data class TransactionModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "transaction_id")
    val transactionId: Int = 0,

    @ColumnInfo(name = "transaction_amount")
    val transactionAmount: Int,

    @ColumnInfo(name = "transaction_notes")
    val transactionNotes: Int
)
