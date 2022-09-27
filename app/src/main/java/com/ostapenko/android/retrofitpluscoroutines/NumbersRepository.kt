package com.ostapenko.android.retrofitpluscoroutines

import android.content.Context
import androidx.room.Room
import com.ostapenko.android.retrofitpluscoroutines.database.NumbersDatabase

private const val DATABASE_NAME = "numbers-database"

class NumbersRepository private constructor(context: Context) {

    private val database: NumbersDatabase = Room.databaseBuilder(
        context.applicationContext,
        NumbersDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val numbersDao = database.numbersDao()

    suspend fun getQuery(number: String): NumbersData {
        return RetrofitHelper.numbersApi.getQueryNumber(number)
    }

    suspend fun addNumber(number: NumbersData) {
        numbersDao.addNumber(number)
    }

    suspend fun getCurrentNumber(text: String): NumbersData {
        return numbersDao.getCurrentNumber(text)
    }

    suspend fun getNumbers(): List<NumbersData> {
        return numbersDao.getSearchedNumbers()
    }

    suspend fun deleteAllNumbers() {
        numbersDao.deleteAllNumbers()
    }

    companion object {
        private var INSTANCE: NumbersRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = NumbersRepository(context)
            }
        }

        fun get(): NumbersRepository {
            return INSTANCE ?: throw IllegalStateException("NumbersRepository must be initialized")
        }
    }
}