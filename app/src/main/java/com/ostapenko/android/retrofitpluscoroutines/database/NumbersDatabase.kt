package com.ostapenko.android.retrofitpluscoroutines.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ostapenko.android.retrofitpluscoroutines.NumbersData

@Database(entities = [NumbersData::class], version = 1, exportSchema = false)
abstract class NumbersDatabase : RoomDatabase() {
    abstract fun numbersDao(): NumbersDao
}

