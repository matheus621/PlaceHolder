package com.example.placeholder.ui.listusers

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.placeholder.repository.AppRepository

class UsersFullViewModel(application: Application) : AndroidViewModel(application) {


    private val appRepository = AppRepository(application)

    init {
        appRepository.fetchDataFromServer(application)
    }


    fun setCurrentSelectedUserId(id: Int) {
        appRepository.setCurrentUserSelected(id)
    }

    fun getUserLiveData() = appRepository.getSingleUserDetails(getCurrentUserSelectId().value!!)

    fun getCurrentUserSelectId() = appRepository.currentUserSelected


}