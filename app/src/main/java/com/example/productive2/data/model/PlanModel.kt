package com.example.productive2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlanModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var description : String
): java.io.Serializable