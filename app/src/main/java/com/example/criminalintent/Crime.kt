package com.example.criminalintent

import java.util.*

data class Crime(val id: UUID = UUID.randomUUID(),
                 var title: String = "",
                 var date: Date = Date(),
                 var isSolved: Boolean = false)

// UUID is universal unique id. call this to generate a random unique id
//Date variable sets today's date as default.