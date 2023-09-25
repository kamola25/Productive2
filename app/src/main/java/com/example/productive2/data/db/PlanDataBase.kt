package com.example.productive2.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.productive2.data.model.PlanModel

@Database(entities = [PlanModel::class], version = 1)
abstract class PlanDataBase : RoomDatabase() {
    abstract fun getDao(): PlanDao

    companion object {
        @Volatile
        private var INSTANCE: PlanDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: buildDatabase(context).also { planDataBase ->
                INSTANCE = planDataBase
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PlanDataBase::class.java,
                "DB_NAME"
            ).allowMainThreadQueries().build()
    }
}