package com.example.nytimesmostpopulararticlesapplication

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun <T> fromList(value: List<T>): String {
    val gson = Gson()
    val type = object : TypeToken<List<T>>() {}.type
    return gson.toJson(value, type)
}

inline fun <reified T> toList(value: String): List<T> {
    val gson = Gson()
    val type = object : TypeToken<List<T>>() {}.type
    return gson.fromJson(value, type)
}