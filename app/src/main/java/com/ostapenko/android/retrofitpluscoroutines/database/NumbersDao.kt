package com.ostapenko.android.retrofitpluscoroutines.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ostapenko.android.retrofitpluscoroutines.NumbersData

@Dao
interface NumbersDao {

    @Query("SELECT * FROM numbers")
    suspend fun getSearchedNumbers(): List<NumbersData>

    @Query("SELECT * FROM numbers WHERE (text= :text)")
    suspend fun getCurrentNumber(text: String): NumbersData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNumber(numbersData: NumbersData)

    @Query("DELETE FROM numbers")
    suspend fun deleteAllNumbers()
}