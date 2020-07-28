package com.example.placeholder.repository

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.placeholder.MainActivity
import com.example.placeholder.api.ApiService
import com.example.placeholder.database.AppDatabase
import com.example.placeholder.model.Users
import com.example.placeholder.util.Utils
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class AppRepository(context: Context) {

    val currentUserSelected: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun setCurrentUserSelected(userIdSelected: Int) {
        currentUserSelected.value = userIdSelected
    }

    fun getSingleUserDetails(id: Int) = database.Dao().getSimpleUser(id)

    val database = AppDatabase.getInstance(context)

    fun getAllUsers() = database.Dao().getAllLiveUsers()

    fun fetchDataFromServer(context: Context) {

        Timber.plant(Timber.DebugTree())
        val request = ApiService.getEndpoints()
        if (Utils.isOnline(context)) {

            request.getAllUsers().enqueue(object : Callback<List<Users>> {
                override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                    Log.e("Falha de comunicação", "Falha no request")
                }

                override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {


                    if (response.code() == 200) {
                        Timber.d("${response.body()}")
                        val resultado = response.body()
                        resultado?.let { users ->
                            users.forEach {
                                doAsync {
                                    database.Dao().insertSimpleUsers(it)
                                }
                            }
                        }
                    }
                }
            })
        } else {
            Toast.makeText(context, "VOCÊ ESTÁ SEM INTERNET", Toast.LENGTH_LONG).show()
            Handler().postDelayed({

                fetchDataFromServer(context)

            }, Toast.LENGTH_LONG.toLong() + 5000)
        }
    }

}