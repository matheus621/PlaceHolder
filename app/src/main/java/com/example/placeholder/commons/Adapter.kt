package com.example.placeholder.commons

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.placeholder.R
import com.example.placeholder.model.Users
import kotlinx.android.synthetic.main.list_users_fragment.view.*
import kotlinx.android.synthetic.main.users_item.view.*

class Adapter(val dataSet: List<Users>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(users: Users) {

            with(itemView) {
                txtName.text = users.name
                txtEmail.text = users.email
                txtPhone.text = users.phone

                rcy_users.setOnClickListener {
                    val userSelectdId = bundleOf("userSelectdId" to users.id)
                    findNavController().navigate(R.id.action_listUsersFragment_to_usersFullFragment, userSelectdId)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.users_item, parent, false)

        return ViewHolder(layoutItem)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(dataSet[position])

    }
}