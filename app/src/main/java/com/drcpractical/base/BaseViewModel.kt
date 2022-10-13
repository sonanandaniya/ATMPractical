package com.drcpractical.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import java.lang.ref.WeakReference

abstract class BaseViewModel(application: Application) :
    AndroidViewModel(application) {

}