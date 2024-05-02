package com.example.todoapp.utils

import android.content.Context
import android.content.SharedPreferences
import android.graphics.ColorSpace.Model
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MySharedPrefernce{
    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences

    fun init(context: Context){
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor)->Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var list: ArrayList<com.example.todoapp.models.Model>
        get() = gsonStringToArray(preferences.getString("obekt", "[]")!!)
        set(value) = preferences.edit {
            it.putString("obekt", arrayToGsonString(value))
        }

    private fun arrayToGsonString(arrayList: ArrayList<com.example.todoapp.models.Model>): String {
        return Gson().toJson(arrayList)
    }

    private fun gsonStringToArray(gsonString: String): ArrayList<com.example.todoapp.models.Model> {
        val typeToken = object : TypeToken<ArrayList<Model>>() {}.type
        return Gson().fromJson(gsonString, typeToken)
    }
}