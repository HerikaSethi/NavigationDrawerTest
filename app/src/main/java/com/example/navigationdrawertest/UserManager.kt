package com.example.navigationdrawertest

import android.content.Context
import android.widget.Toast
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserManager(context: Context) {
    private val dataStore = context.createDataStore(name = "user_prefs")
    companion object{
        val USER_NAME_KEY = preferencesKey<String>("USER_NAME")
        val USER_AGE_KEY = preferencesKey<Int>("USER_AGE")
        val USER_GENDER_KEY = preferencesKey<Boolean>("USER_GENDER")
    }

    //suspend function that will store the data
    suspend fun storeUser(age:Int,name:String,isMale:Boolean){
        //for editting
        dataStore.edit {
            it[USER_NAME_KEY] = name
            it[USER_AGE_KEY] = age
            it[USER_GENDER_KEY] = isMale
        }
    }
    //creating flows which help in retrieving the data
    val userNameFlow: Flow<String> = dataStore.data.map{
        //it will refer to preferences
        //if key not present, return empty string
        it[USER_NAME_KEY] ?: ""
    }
    val userAgeFlow: Flow<Int> = dataStore.data.map {
        val age = it[USER_AGE_KEY] ?: 0
        if(age<18)
        { Toast.makeText(context, "The user is under 18", Toast.LENGTH_SHORT).show()}
        age
    }
    val userGenderFlow: Flow<Boolean> = dataStore.data.map {
        //if user gender key not null then return its value else return false
        it[USER_GENDER_KEY] ?: false
    }

}