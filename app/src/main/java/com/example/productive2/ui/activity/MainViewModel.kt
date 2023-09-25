package com.example.productive2.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.productive2.data.model.PlanModel
import com.example.productive2.data.repo.PlanRepository


class MainViewModel (
): ViewModel() {

    private val repo = PlanRepository()
    var liveData: LiveData<List<PlanModel>> = MutableLiveData()

    fun getAllNotes() {
        liveData = repo.getAllNotes()
    }

    fun setUser(model: PlanModel) {
        repo.setNote(model)
    }

    fun deleteNote(model: PlanModel) {
        repo.deleteNote(model)
    }

    fun updateNote(model: PlanModel) {
        repo.updateModel(model)
    }
}