package com.example.placeholder.ui.listusers

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.placeholder.repository.AppRepository

class ListUsersViewModel(application: Application) : AndroidViewModel(application) {

    private val appRepository = AppRepository(application)

    init {
        appRepository.fetchDataFromServer(application)
    }

    fun getAllUsers() = appRepository.getAllUsers()


}
