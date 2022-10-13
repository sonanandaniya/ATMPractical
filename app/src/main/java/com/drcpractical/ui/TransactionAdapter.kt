package com.drcpractical.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.drcpractical.data.TransactionModel
import com.drcpractical.databinding.RowTransactionBinding

class TransactionAdapter() :
    ListAdapter<TransactionModel, TransactionAdapter.TransactionViewHolder>(
        StringTransactionDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(
            RowTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(
            getItem(position)
        )
    }

    inner class TransactionViewHolder(var binding: RowTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TransactionModel) {
            binding.transaction = item
        }
    }

    class StringTransactionDiffCallback() : DiffUtil.ItemCallback<TransactionModel>() {
        override fun areItemsTheSame(
            oldItem: TransactionModel,
            newItem: TransactionModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: TransactionModel,
            newItem: TransactionModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}