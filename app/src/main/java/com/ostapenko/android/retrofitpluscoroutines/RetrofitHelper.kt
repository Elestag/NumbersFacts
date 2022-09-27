package com.ostapenko.android.retrofitpluscoroutines

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val baseUrl = "http://numbersapi.com/"

    val numbersApi: NumbersApi by lazy {
        getInstance().create(NumbersApi::class.java)
    }

    fun getInstance(): Retrofit {
        val gson = GsonBuilder().registerTypeAdapter(NumbersData::class.java, DeserializerNumber())
            .create()

        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}