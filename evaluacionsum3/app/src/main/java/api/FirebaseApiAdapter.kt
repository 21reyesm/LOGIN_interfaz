package com.example.evaluacionsum3.api

import com.example.evaluacionsum3.api.response.PostResponse
import com.example.evaluacionsum3.api.response.WeaponResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FirebaseApiAdapter {
    private var URL_BASE = "https://cyberpunk-database.firebaseio.com/"
    private val firebaseApi = Retrofit.Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getWeapons(): MutableMap<String, WeaponResponse>? {
        val call = firebaseApi.create(FirebaseApi::class.java).getWeapons().execute()
        val weapons = call.body()
        return weapons
    }

    fun getWeapon(id: String): WeaponResponse? {
        val call = firebaseApi.create(FirebaseApi::class.java).getWeapon(id).execute()
        val weapon = call.body()
        weapon?.id = id
        return weapon
    }

    fun setWeapon(weapon: WeaponResponse): PostResponse? {
        val call = firebaseApi.create(FirebaseApi::class.java).setWeapon(weapon).execute()
        val results = call.body()
        return results
    }
}