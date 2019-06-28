package com.dmitriy.android.nbuexchange.presenter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class BasePresenter<T : BaseView> : CoroutineScope {
    private val Job = Job()
    protected var view: T? = null

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job

    fun destroy() {
        Job.cancel()
        view = null
    }

    protected fun viewSetter(view: T) {
        this.view = view
    }
}