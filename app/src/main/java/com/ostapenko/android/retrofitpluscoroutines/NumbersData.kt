package com.ostapenko.android.retrofitpluscoroutines

import androidx.room.Entity
import androidx.room.PrimaryKey


// data class QuoteList
// according to JSON response
@Entity(tableName = "numbers")
data class NumbersData(
    @PrimaryKey var text: String,
    var found: String,
    var number: String,
    var type: String,
    var date: String,
    var year: String
)
