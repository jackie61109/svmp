package com.fet.svmp.viewmodel

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by i_jackiechen1 on 2019/2/21 下午2:09.
 */
open class BaseViewModel(): ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun addDisposable(d: Disposable) {
        compositeDisposable.add(d)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}