package com.drcpractical.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.drcpractical.R
import com.drcpractical.data.TransactionDao
import com.drcpractical.data.TransactionModel
import com.drcpractical.databinding.ActivityMainBinding
import com.drcpractical.viewModels.HomeViewModel
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var mViewModel: HomeViewModel

    @Inject
    lateinit var transactionDao: TransactionDao

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TransactionAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        initView()
    }

    private fun initView() {
        binding.viewModel = mViewModel
        setRecyclerView()
        setObserver()
    }

    private fun setRecyclerView() {
        adapter = TransactionAdapter()
        layoutManager = LinearLayoutManager(this)
        binding?.rvHistory?.let {
            it.adapter = adapter
            it.layoutManager = layoutManager
        }
    }

    private fun setObserver() {
        transactionDao.getTransaction().observe(this, transactionListObserver)
    }

    private var transactionListObserver = Observer<List<TransactionModel>> {
        if (it != null && it.isNotEmpty()) {
            binding.groupHistory.visibility = View.VISIBLE
            adapter.submitList(it)
            binding.tvAvailableBalanceValue.text = mViewModel.availableAmount
            binding.tvAvailableNoteValue.text =
                mViewModel.getNumberOfNotes(mViewModel.availableAmount.toInt()).toString()
        } else {
            binding.groupHistory.visibility = View.GONE
        }
    }
}