package com.ostapenko.android.retrofitpluscoroutines

import android.app.Application

class NumbersApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        NumbersRepository.initialize(this)
    }
}