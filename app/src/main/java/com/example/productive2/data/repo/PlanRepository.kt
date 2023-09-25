package com.example.productive2.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.productive2.data.model.PlanModel
import com.example.productive2.ui.utills.App

class PlanRepository{

    private val dao = App.db.getDao()

    fun getAllNotes(): LiveData<List<PlanModel>> {
        val liveData = MutableLiveData<List<PlanModel>>()
        liveData.value = dao.getAllNote()
        return liveData
    }

    fun setNote(model: PlanModel) {
        dao.addNote(model)
    }

    fun deleteNote(model: PlanModel) {
        dao.deleteNote(model)
    }

    fun updateModel(model: PlanModel) {
        dao.updateNote(model)
    }
}