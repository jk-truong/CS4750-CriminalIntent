package com.example.criminalintent

import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()

    //This adds a crime when the menu add button is pressed
    fun addCrime(crime: Crime) {
        crimeRepository.addCrime(crime)
    }
}
