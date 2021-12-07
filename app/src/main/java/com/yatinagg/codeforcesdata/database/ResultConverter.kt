package com.yatinagg.codeforcesdata.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yatinagg.codeforcesdata.model.Result
import java.lang.reflect.Type
import java.util.*


class ResultConverter {
    @TypeConverter
    fun getObjectFromString(value: String): List<Result> {
        val listType: Type? = object : TypeToken<ArrayList<Result?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun getStringFromObject(results: List<Result>): String {
        val gson = Gson()
        return gson.toJson(results)
    }
}