package com.drcpractical.viewModels

import android.app.Application
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.drcpractical.base.BaseViewModel
import com.drcpractical.data.TransactionDao
import com.drcpractical.data.TransactionModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    application: Application
) : BaseViewModel(application) {
    private val notesList = listOf(2000, 500, 200, 100, 50, 20, 10)
    var availableAmount = "60000";
    var availableNotes = getNumberOfNotes(availableAmount.toInt());
    var withdrawalAmount = MutableLiveData<String>()

    @Inject
    lateinit var transactionDao: TransactionDao

    private fun isAmountValid(): Boolean {
        if (TextUtils.isEmpty(withdrawalAmount.value)) {
            showToast("Please enter amount")
            return false
        } else {
            val withdrawalAmount = withdrawalAmount.value!!.toInt()
            if (withdrawalAmount > availableAmount.toInt() || withdrawalAmount <= 0) {
                showToast("You do not have sufficient account balance")
                return false
            } else if (withdrawalAmount % 10 != 0) {
                showToast("Withdrawal amount should be multiple of 10")
                return false
            }
            return true
        }
    }

    public fun withdrawAmount() {
        if (isAmountValid()) {
            val notesCount = getNumberOfNotes(withdrawalAmount.value!!.toInt());
            val transaction = TransactionModel(
                transactionAmount = withdrawalAmount.value!!.toInt(),
                transactionNotes = notesCount
            )
            val isInsert = transactionDao.addTransaction(transaction)
            Log.e("isInsert ", isInsert.toString())
            availableAmount =
                ((availableAmount.toInt() - withdrawalAmount.value!!.toInt()).toString());

            withdrawalAmount.postValue("")
        }
    }

    public fun getNumberOfNotes(amountToConsider: Int): Int {
        var notesCount = 0;
        var amount = amountToConsider
        for (note in notesList) {
            notesCount += (amount / note)
            amount %= note
            if (amount == 0)
                break
        }
        return notesCount
    }

    fun showToast(message: String) {
        Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show()
    }
}