package com.ostapenko.android.retrofitpluscoroutines

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NumbersApi {

    @GET("/{pathNumber}?json")
    suspend fun getQueryNumber(@Path("pathNumber") number: String): NumbersData
}