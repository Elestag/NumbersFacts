package com.ostapenko.android.retrofitpluscoroutines

import android.util.Log
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

private const val TAG = "Deserializer"

class DeserializerNumber : JsonDeserializer<NumbersData> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): NumbersData {

        val jsonObject: JsonObject? = json?.asJsonObject
        val factText = jsonObject?.get("text").toString().replace("\"","")
        val factFound = jsonObject?.get("found").toString()
        val factNumber = jsonObject?.get("number").toString()
        val factType = jsonObject?.get("type").toString()
        val factDate = jsonObject?.get("date").toString()
        val factYear = jsonObject?.get("year").toString()

        val deserializedNumber =
            NumbersData(factText, factFound, factNumber, factType, factDate, factYear)

        Log.d(TAG, "Json is : $jsonObject")
        Log.d(TAG, "Json is : $deserializedNumber")

        return deserializedNumber
    }
}

//text: A string of the fact text itself.
//found: Boolean of whether there was a fact for the requested number.
//number: The floating-point number that the fact pertains to. This may be useful for, eg. a /random request or notfound=floor. For a date fact, this is the 1-indexed day of a leap year (eg. 61 would be March 1st).
//type: String of the category of the returned fact.
//date (sometimes): A day of year associated with some year facts, as a string.
//year (sometimes): A year associated with some date facts, as a string.