package com.example.placeholder.ui.listusers

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.placeholder.R
import com.example.placeholder.commons.Adapter
import kotlinx.android.synthetic.main.list_users_fragment.*

class ListUsersFragment : Fragment() {

    private lateinit var viewModel: ListUsersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_users_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()

        viewModel = ViewModelProviders.of(this).get(ListUsersViewModel::class.java)


        viewModel.getAllUsers().observe(this, Observer { users ->
            recyclerView.adapter = Adapter(users)
            recyclerView.layoutManager = LinearLayoutManager(context)
        })
    }


}