package com.ederfmatos.kotlintestdatabuilder.singleton

import com.google.gson.Gson

object GsonObject {

    private val gson: Gson = Gson()

    fun toJson(value: Any): String = gson.toJson(value)

    fun <T : Any> fromJson(json: String, resultClass: Class<T>): T = gson.fromJson(json, resultClass)

}