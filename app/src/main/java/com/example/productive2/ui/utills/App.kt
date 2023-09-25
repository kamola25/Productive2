package com.example.productive2.ui.utills

import android.app.Application
import android.content.SharedPreferences
import com.example.productive2.data.db.PlanDataBase

class App : Application() {
    private lateinit var preferences: SharedPreferences

    companion object {
        lateinit var prefs: Prefs
        lateinit var db: PlanDataBase
    }

    override fun onCreate() {
        super.onCreate()
        preferences = this.applicationContext
            .getSharedPreferences("settings", MODE_PRIVATE)
        prefs = Prefs(preferences)
        db = PlanDataBase(this)
    }
}