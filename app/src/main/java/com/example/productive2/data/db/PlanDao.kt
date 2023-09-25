package com.example.productive2.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.productive2.data.model.PlanModel

@Dao
interface PlanDao {
    @Query("SELECT * FROM planmodel")
    fun getAllNote(): List<PlanModel>

    @Insert
    fun addNote(model: PlanModel)

    @Delete
    fun deleteNote(model: PlanModel)

    @Update
    fun updateNote(model: PlanModel)
}