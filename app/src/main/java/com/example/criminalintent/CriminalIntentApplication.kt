package com.example.criminalintent

import android.app.Application

//This is launched at the beginning of app and ended when app is destroyed
class CriminalIntentApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}